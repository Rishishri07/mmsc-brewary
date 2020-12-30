package rishi.springFramework.mmscbrewary.web.controller.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp time) {
        if (time != null) {
            return OffsetDateTime.of(time.toLocalDateTime().getYear(), time.toLocalDateTime().getMonthValue(),
                    time.toLocalDateTime().getDayOfMonth(), time.toLocalDateTime().getHour(), time.toLocalDateTime().getMinute(),
                    time.toLocalDateTime().getSecond(), time.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }
}
