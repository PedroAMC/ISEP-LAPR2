package app.domain.utils;

import java.util.List;

public interface CsvExport <T> {

    public void exportData(List<T> list);

}
