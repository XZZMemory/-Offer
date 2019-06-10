package utils;

import utils.myObject.CommonTree;

import java.util.ArrayList;
import java.util.List;

/**
 * created by memory
 * on 2019/6/10 下午8:57
 */
public class CommonTreeUtil {
    public static List<CommonTree> create() {
        //创建树
        CommonTree root = new CommonTree();
        root.info = 'A';
        CommonTree B = new CommonTree();
        B.info = 'B';
        CommonTree C = new CommonTree();
        C.info = 'C';
        CommonTree D = new CommonTree();
        D.info = 'D';
        CommonTree E = new CommonTree();
        E.info = 'E';
        CommonTree F = new CommonTree();
        F.info = 'F';
        CommonTree G = new CommonTree();
        G.info = 'G';
        CommonTree H = new CommonTree();
        H.info = 'H';
        CommonTree I = new CommonTree();
        I.info = 'I';
        CommonTree J = new CommonTree();
        J.info = 'J';
        root.childs = new CommonTree[]{B, C};
        B.childs = new CommonTree[]{D, E};
        D.childs = new CommonTree[]{F, G};
        E.childs = new CommonTree[]{H, I, J};
        List<CommonTree> list = new ArrayList<>();
        list.add(root);
        list.add(H);
        return list;
    }
}
