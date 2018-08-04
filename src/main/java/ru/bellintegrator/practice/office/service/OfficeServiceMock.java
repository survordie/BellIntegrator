package ru.bellintegrator.practice.office.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class OfficeServiceMock implements OfficeService {

    @Override
    public List<OfficeView> getOffices() {
        List<OfficeView> officeViewList = new ArrayList<>();

        OfficeView officeView = new OfficeView();
        officeView.isActive = true;
        officeView.name = "Офис 1";
        officeView.address = "Address 1";
        officeView.phone = "phone 1";
        officeView.organizationId = 1L;

        officeViewList.add(officeView);

        return officeViewList;
    }

    @Override
    public OfficeView getOfficeById(OfficeView officeView) {

        officeView.isActive = true;
        officeView.name = "Офис 1";
        officeView.address = "Address 1";
        officeView.phone = "phone 1";
        officeView.organizationId = 1L;

        return officeView;
    }

    @Override
    public String updateOffice(OfficeView officeView) {
        return "success";
    }

    @Override
    public String saveOffice(OfficeView officeView) {
        return "success";
    }
}
