import java.util.Date;
import java.util.Random;

public class DifferentialEvolution4SeachParam {
    private int population_size;
    private int iter_num;
    private int param_num;
    private double param_bottom_bound;
    private double param_upper_bound;
    private double F = 0.5;        // mutation factor [0, 1], range from 0 to 1
    private double CR = 0.5;        // cross rate (0, 1)

    // tmp
    private double[][] population;
    private double[] scores;
    private Random rand;

    // output
    private double[] final_individual;

    public static void main(String[] args) {
        DifferentialEvolution4SeachParam de = new DifferentialEvolution4SeachParam(10, 500, 5, -1, 1);
        double[] params = de.getTheFinalParams();

        System.out.println();
        for (int j = 0; j < params.length - 1; j++)
            System.out.print(params[j] + ", ");
        System.out.println(params[params.length - 1] + ")");
        System.out.println("HAVE A GOOD DAY!");
    }

    public DifferentialEvolution4SeachParam(int population_size, int iter_num,
                                            int param_num, double param_bottom_bound, double param_upper_bound) {
        this.population_size = population_size;
        this.iter_num = iter_num;
        this.param_num = param_num;
        this.param_bottom_bound = param_bottom_bound;
        this.param_upper_bound = param_upper_bound;

        final_individual = run();
    }

    public double[] getTheFinalParams() {
        return final_individual;
    }

    private double[] run() {
        this.init();

        double[] final_best_individual = null;
        for (int iter = 0; iter < iter_num; iter++) {
            double[][] mutated_population = this.mutate();
            double[][] crossed_population = this.cross(mutated_population);
            this.select(crossed_population);

            int[] index = insertDescendSortIndex(scores, 1);

            StringBuffer sb = new StringBuffer();
            sb.append("The " + (iter + 1) + "-th iter's score is " + scores[index[0]] + " (");
            for (int j = 0; j < param_num - 1; j++)
                sb.append(this.population[index[0]][j] + ", ");
            sb.append(this.population[index[0]][param_num - 1] + ")");

            System.out.println(sb.toString());

            final_best_individual = this.population[index[0]];
        }

        return final_best_individual;
    }

    /*获取最大数的下标,冒泡排序思想*/
    private int[] insertDescendSortIndex(final double[] arr, int sortTopN) {
        int[] indexes = new int[arr.length];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = i;

        for (int i = 1; i < indexes.length; i++) {
            for (int j = 0; j < i && j < sortTopN; j++) {
                if (arr[indexes[i]] > arr[indexes[j]]) {
                    int tmp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = tmp;
                }
            }
        }

        if (indexes.length > sortTopN) {
            int[] ans = new int[sortTopN];
            for (int i = 0; i < sortTopN; i++) {
                ans[i] = indexes[i];
            }

            return ans;
        }

        return indexes;
    }

    private void init() {
        rand = new Random(new Date().getTime());

        population = new double[population_size][param_num];
        scores = new double[population_size];
        for (int i = 0; i < population_size; i++) {
            for (int j = 0; j < param_num; j++) {
                population[i][j] = param_bottom_bound + rand.nextDouble() * (param_upper_bound - param_bottom_bound);
            }

            scores[i] = scorefunc(population[i]);
        }
    }

    private double[][] mutate() {
        double[][] mutated_population = new double[population_size][param_num];
        for (int i = 0; i < population_size; i++) {
            /* Random.nextInt() 在一个范围内随机取一个整数 */
            int ind1 = rand.nextInt(population_size);
            int ind2 = rand.nextInt(population_size);
            int ind3 = rand.nextInt(population_size);
            while (ind1 == i || ind2 == i || ind3 == i
                    || ind1 == ind2 || ind1 == ind3 || ind2 == ind3) {
                ind1 = rand.nextInt(population_size);
                ind2 = rand.nextInt(population_size);
                ind3 = rand.nextInt(population_size);
            }

            /*一个个体的基因是从1-param_num，是一个个体，当前个体是i，编*/
            for (int j = 0; j < param_num; j++) {
                mutated_population[i][j] = population[ind1][j] + F * (population[ind2][j] - population[ind3][j]);
            }
        }

        return mutated_population;
    }

    private double[][] cross(double[][] mutated_population) {
        double[][] crossed_population = new double[population_size][param_num];//交叉后的种群
        for (int i = 0; i < population_size; i++) {//交叉后的种群数量与原始种群大小一样，当前交叉获得的个体是 i
            int Jrand = rand.nextInt(param_num);//随机选择一个个体
            for (int j = 0; j < param_num; j++) {
                if (j == Jrand || rand.nextDouble() < CR)//CR：交叉概率
                    crossed_population[i][j] = mutated_population[i][j];//小于交叉概率，不交叉。当前交叉操作获得的个体就是传进来变异个体
                else crossed_population[i][j] = population[i][j];
                /*不满足条件，进行修复，重新生成当前个体*/
                if (crossed_population[i][j] > this.param_upper_bound
                        || crossed_population[i][j] < this.param_bottom_bound) {
                    crossed_population[i][j] = param_bottom_bound + rand.nextDouble() * (param_upper_bound - param_bottom_bound);
                }
            }
        }

        return crossed_population;
    }

    private void select(double[][] crossed_population) {
        for (int i = 0; i < population_size; i++) {
            double new_sco = scorefunc(crossed_population[i]);
            if (new_sco > scores[i]) {
                population[i] = crossed_population[i];
                scores[i] = new_sco;
            }
        }
    }

    private double scorefunc(double[] individual) {    // TODO the higher, the better.
        double sco = 0.0;
        for (int i = 0; i < param_num; i++)
            sco += individual[i];

        return sco;
    }
}