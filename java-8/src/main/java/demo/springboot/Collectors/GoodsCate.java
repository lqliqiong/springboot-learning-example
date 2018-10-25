package demo.springboot.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCate {

    private Long cateId;

    private String cateName;

    private Long cateParentId;
}