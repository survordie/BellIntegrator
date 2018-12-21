package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

/**
 * Сервис для работы с офисами
 */
public interface OfficeService {

    /**
     * Получить все офисы
     *
     * @param officeView
     *
     * @return
     */
    List<OfficeView> getOffices(OfficeView officeView);

    /**
     * Получить офис по Id
     *
     * @param id
     *
     * @return
     */
    OfficeView getOfficeById(Long id);

    /**
     * Обновить офис
     *
     * @param officeView
     *
     * @return
     */
    ResultView updateOffice(OfficeView officeView);

    /**
     * Добавить офис
     *
     * @param officeView
     *
     * @return
     */
    ResultView saveOffice(OfficeView officeView);
}
