package com.julyerr.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOps {
    private enum Status {
        OPEN, CLOSED;
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        @Override
        public String toString() {
            return String.format("[%s,%d]", status, points);
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );
//        过滤流，转换流，对应操作
        final long totalPoints = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println(totalPoints);

//        收集器
        final Map<Status, List<Task>> map = tasks.stream()
                .collect(Collectors.groupingBy(task -> task.getStatus()));
        System.out.println(map);

//        并行流操作,map-reduce
        final double totalPointsD = tasks.stream()
                .parallel().map(Task::getPoints)
//                累加器
                .reduce(0, Integer::sum);
        System.out.println(totalPointsD);

//        比较复杂的操作
        final Collection<String> collection = tasks.stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble(point -> point / totalPointsD)
                .boxed()
                .mapToLong(weight -> (long) (weight * 100))
                .mapToObj(percent -> percent + "%")
                .collect(Collectors.toList());
        System.out.println(collection);
    }
}
