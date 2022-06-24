package app.domain.utils;

import app.domain.utils.TimeInterval;
import app.domain.utils.TimeSlot;

import java.util.List;

/**
 * Interface containing the algorithms used for the brute-force.
 *
 * @author Pedro Campos <1211511@isep.ipp.pt> */

public interface Algorithms {

    public TimeInterval determineLeastEffectiveTimeInterval(List<TimeSlot> centerPerformance);

    public TimeInterval getIntervalSum(List<TimeSlot> centerPerformance, int start, int end);

    public int[] sum(final int[] seq);



}
