package pt.iade.unimanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager.models.GroupResult;
import pt.iade.unimanager.models.HistogramSlot;
import pt.iade.unimanager.models.Statistical;
import pt.iade.unimanager.models.StatisticsResult;
import pt.iade.unimanager.models.StudentRepository;
import pt.iade.unimanager.models.TeacherRepository;
import pt.iade.unimanager.models.UnitRepository;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path="/api/statistics")

public class StatisticsController {
    private Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    private static final int NHISTSLOTS = 5;

    @GetMapping(path = "/histogram/{type}/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public HistogramSlot[] getHistogram( 
        @PathVariable("type") String type, @PathVariable("number") int number){
            logger.info("Obtaining histogram info");
            Statistical stats;
            if (type.equalsIgnoreCase("student"))
            stats = StudentRepository.getStudent(number);
            else stats = UnitRepository.getUnit(number);
            return stats.getHistogram(NHISTSLOTS);
        }

        @GetMapping(path = "/{type}/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
        public StatisticsResult getStatistics( 
             @PathVariable("type") String type, @PathVariable("number") int number){
                logger.info("Obtaining statistics");
                Statistical stats;
                if (type.equalsIgnoreCase("student"))
                stats = StudentRepository.getStudent(number);
                else stats = UnitRepository.getUnit(number);
                return new StatisticsResult(stats.getAverage(), stats.getMax(), stats.getMin(), stats.getRange());
            }



    }