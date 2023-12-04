package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(new Job("Fix bug", 1), new Job("Impl task", 0));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(new Job("Fix bug", 1), new Job("Impl task", 0));
        assertThat(rsl).isGreaterThan(0);
    }
}
