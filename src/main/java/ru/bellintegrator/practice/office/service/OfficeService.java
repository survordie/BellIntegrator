package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

public interface OfficeService {

    /**
     * Получить все офисы
     */
    List<OfficeView> getOffices(OfficeView officeView);

    /**
     * Получить офис по Id
     */
    OfficeView getOfficeById(Long id);

    /**
     * Обновить офис
     */
    ResultView updateOffice(OfficeView officeView);

    /**
     * Добавить офис
     */
    ResultView saveOffice(OfficeView officeView);
}
