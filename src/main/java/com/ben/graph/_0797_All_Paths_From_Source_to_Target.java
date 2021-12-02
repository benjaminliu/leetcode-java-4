package com.ben.graph;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0797_All_Paths_From_Source_to_Target {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        PrintUtil.printListOfList(new Solution1().allPathsSourceTarget(graph));
    }

    public static class Solution1 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();

            List<Integer> group = new ArrayList<>(graph.length);
            group.add(0);
            traverse(graph, 0, group, res);

            return res;
        }

        private void traverse(int[][] graph, int idx, List<Integer> group, List<List<Integer>> res) {
            //We arrived at the last node
            if (idx == graph.length - 1) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i : graph[idx]) {
                group.add(i);
                traverse(graph, i, group, res);
                group.remove(group.size() - 1);
            }
        }
    }

    public static class Solution2 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();

            List<Integer> group = new ArrayList<>(graph.length);
            traverse(graph, 0, group, res);

            return res;
        }

        private void traverse(int[][] graph, int idx, List<Integer> group, List<List<Integer>> res) {
            group.add(idx);

            //We arrived at the last node
            if (idx == graph.length - 1) {
                res.add(new ArrayList<>(group));
            } else {
                for (int i : graph[idx]) {
                    traverse(graph, i, group, res);
                }
            }

            group.remove(group.size() - 1);
        }
    }
}
