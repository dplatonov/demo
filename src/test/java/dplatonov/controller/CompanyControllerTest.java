package dplatonov.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dplatonov.model.Company;
import dplatonov.service.CompanyService;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CompanyService service;

  private final Long id = 1L;
  private Company expectedCompany;
  private List<Company> expectedCompanies;

  @Before
  public void setUp() {
    expectedCompany = new Company();
    expectedCompany.setId(id);

    expectedCompanies = Arrays.asList(expectedCompany, expectedCompany);
  }

  @Test
  public void getCompanies() throws Exception {
    when(service.findAll()).thenReturn(expectedCompanies);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/company")).andExpect(status().isOk());
  }

  @Test
  public void getById() throws Exception {
    when(service.findById(id)).thenReturn(expectedCompany);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/company/" + id)).andExpect(status().isOk());
  }
}
