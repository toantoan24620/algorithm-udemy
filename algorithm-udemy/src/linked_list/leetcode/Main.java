package linked_list.leetcode;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import linked_list.question.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        spiralMatrix(1,4,null);
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int rowTop = 0, colTop = 0, rowBottom = m - 1, colBottom = n - 1;
        int[][] rs = new int[m][n];
        if(n == 1){
            for(int i = 0; i < m; i++){
                rs[i][0] = head == null ? -1 : head.val;
                head = head == null ? null : head.next;
            }
        }else if(m == 1){
            for(int i = 0; i < n; i++){
                rs[0][i] = head == null ? -1 : head.val;
                head = head == null ? null : head.next;
            }
        }else{
            while(rowTop < rowBottom && colTop < colBottom){
                for(int i = colTop; i <= colBottom; i++){
                    rs[rowTop][i] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
                rowTop++;

                for(int i = rowTop; i <= rowBottom; i++){
                    rs[i][colBottom] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
                colBottom--;

                for(int i = colBottom; i >= colTop; i--){
                    rs[rowBottom][i] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
                rowBottom--;

                for(int i = rowBottom; i >= rowTop; i--){
                    rs[i][colTop] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
                colTop++;
            }
            if(m % 2 == 1){
                for(int i = colTop; i <= colBottom; i++){
                    rs[rowTop][i] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
                rowTop++;
            }
            if(n % 2 == 1){
                for(int i = rowTop; i <= rowBottom; i++){
                    rs[i][colTop] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
            }
        }
        return rs;
    }
}
