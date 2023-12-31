package com.example.competitie;

import com.example.competitie.dto.CompetitieRequest;
import com.example.competitie.dto.CompetitieResponse;
import com.example.competitie.model.Competitie;
import com.example.competitie.repository.CompetitieRepository;
import com.example.competitie.service.CompetitieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CompetitieApplicationTests {

    @Mock
    private CompetitieRepository competitieRepository;
    @InjectMocks
    private CompetitieService competitieService;
    @Test
    public void testCreateCompetitie() {

        int startYear = 2023;
        int startMonth = 5; // May
        int startDay = 15;
        int startHour = 10;
        int startMinute = 30;
        int startSecond = 0;

        int endYear = 2023;
        int endMonth = 6; // June
        int endDay = 1;
        int endHour = 15;
        int endMinute = 45;
        int endSecond = 0;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute, startSecond);
        Date startDate = startCalendar.getTime();

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute, endSecond);
        Date endDate = endCalendar.getTime();

        CompetitieRequest competitieRequest = new CompetitieRequest();
        competitieRequest.setSkuCode("SKU123");
        competitieRequest.setProvincie("Test Provincie");
        competitieRequest.setCompetitieleider("Test Leider");
        competitieRequest.setStartDatum(startDate);
        competitieRequest.setEindDatum(endDate);
        competitieRequest.setPloegen(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"));

        competitieService.createCompetitie(competitieRequest);

        //verify(competitieRepository, times(1)).save(any(Competitie.class));
    }

    @Test
    public void testGetAllCompetities() {

        int startYear = 2023;
        int startMonth = 5; // May
        int startDay = 15;
        int startHour = 10;
        int startMinute = 30;
        int startSecond = 0;

        int endYear = 2023;
        int endMonth = 6; // June
        int endDay = 1;
        int endHour = 15;
        int endMinute = 45;
        int endSecond = 0;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute, startSecond);
        Date startDate = startCalendar.getTime();

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute, endSecond);
        Date endDate = endCalendar.getTime();
        // Arrange
        Competitie competitie = new Competitie();
        competitie.setCompetitieId("1");
        competitie.setSkuCode("SKU123");
        competitie.setProvincie("Test Provincie");
        competitie.setCompetitieleider("Test Leider");
        competitie.setStartDatum(startDate);
        competitie.setEindDatum(endDate);
        competitie.setPloegen(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"));


        when(competitieRepository.findAll()).thenReturn(List.of(competitie));

        // Act
        List<CompetitieResponse> competities = competitieService.getAllCompetities();

        // Assert
        assertEquals(1, competities.size());
        assertEquals("SKU123", competities.get(0).getSkuCode());
        assertEquals("Test Provincie", competities.get(0).getProvincie());
        assertEquals("Test Leider", competities.get(0).getCompetitieleider());
        assertEquals(startDate, competities.get(0).getStartDatum());
        assertEquals(endDate, competities.get(0).getEindDatum());
        assertEquals(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"), competities.get(0).getPloegen());

        verify(competitieRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllCompetitiesBySkuCode() {
        // Arrange
        int startYear = 2023;
        int startMonth = 5; // May
        int startDay = 15;
        int startHour = 10;
        int startMinute = 30;
        int startSecond = 0;

        int endYear = 2023;
        int endMonth = 6; // June
        int endDay = 1;
        int endHour = 15;
        int endMinute = 45;
        int endSecond = 0;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute, startSecond);
        Date startDate = startCalendar.getTime();

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute, endSecond);
        Date endDate = endCalendar.getTime();
        // Arrange
        Competitie competitie = new Competitie();
        competitie.setCompetitieId("1");
        competitie.setSkuCode("SKU123");
        competitie.setProvincie("Test Provincie");
        competitie.setCompetitieleider("Test Leider");
        competitie.setStartDatum(startDate);
        competitie.setEindDatum(endDate);
        competitie.setPloegen(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"));


        when(competitieRepository.findBySkuCodeIn(List.of("SKU123"))).thenReturn(List.of(competitie));

        // Act
        List<CompetitieResponse> competitieResponses = competitieService.getAllCompetitiesBySkuCode(List.of("SKU123"));

        // Assert
        assertEquals(1, competitieResponses.size());
        assertEquals("SKU123", competitieResponses.get(0).getSkuCode());
        assertEquals("Test Provincie", competitieResponses.get(0).getProvincie());
        assertEquals("Test Leider", competitieResponses.get(0).getCompetitieleider());
        assertEquals(startDate, competitieResponses.get(0).getStartDatum());
        assertEquals(endDate, competitieResponses.get(0).getEindDatum());
        assertEquals(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"), competitieResponses.get(0).getPloegen());

        verify(competitieRepository, times(1)).findBySkuCodeIn(Collections.singletonList(competitie.getSkuCode()));
    }

    @Test
    public void testDeleteCompetitie() {

        int startYear = 2023;
        int startMonth = 5; // May
        int startDay = 15;
        int startHour = 10;
        int startMinute = 30;
        int startSecond = 0;

        int endYear = 2023;
        int endMonth = 6; // June
        int endDay = 1;
        int endHour = 15;
        int endMinute = 45;
        int endSecond = 0;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute, startSecond);
        Date startDate = startCalendar.getTime();

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute, endSecond);
        Date endDate = endCalendar.getTime();

        CompetitieRepository competitieRepository1 = mock(CompetitieRepository.class);
        CompetitieService competitieService1 = new CompetitieService(competitieRepository1);

        // Arrange
        Competitie competitie = new Competitie();
        competitie.setCompetitieId("1");
        competitie.setSkuCode("SKU123");
        competitie.setProvincie("Test Provincie");
        competitie.setCompetitieleider("Test Leider");
        competitie.setStartDatum(startDate);
        competitie.setEindDatum(endDate);
        competitie.setPloegen(Arrays.asList("Ploeg 1", "Ploeg 2", "Ploeg 3", "Ploeg 4", "Ploeg 5"));


        when(competitieRepository1.findBySkuCodeIn(List.of("SKU123"))).thenReturn(List.of(competitie));

        // Act
        competitieService1.delete("SKU123");

        // Assert
        verify(competitieRepository1, times(1)).findBySkuCodeIn(List.of("SKU123"));
    }


}
