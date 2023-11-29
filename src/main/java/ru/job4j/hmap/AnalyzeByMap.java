package ru.job4j.hmap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToDouble(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return pupils.stream()
                .map(pupil -> new Label(pupil.name(), pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new LinkedHashMap<>();
        pupils.forEach(pupil -> pupil.subjects().forEach(subject ->
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum)));
        return subjectScores.entrySet().stream()
                .map(entry -> new Label(entry.getKey(), entry.getValue() / pupils.size()))
                .collect(Collectors.toList());
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return pupils.stream()
                .map(pupil -> new Label(pupil.name(), pupil.subjects().stream()
                        .mapToDouble(Subject::score)
                        .sum()))
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new LinkedHashMap<>();
        pupils.forEach(pupil -> pupil.subjects().forEach(subject ->
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum)));
        return subjectScores.entrySet().stream()
                .map(entry -> new Label(entry.getKey(), entry.getValue()))
                .max(Comparator.naturalOrder())
                .orElse(null);
    }
}