package dbp.techcall.meetingDetails.domain;

import dbp.techcall.booking.domain.Booking;
import dbp.techcall.meetingDetails.infrastructure.MeetingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MeetingDetailsService {

    @Autowired
    private MeetingDetailsRepository meetingDetailsRepository;

    @Async
    public void createMeetingDetailsAync(Booking booking, String hostRoomUrl, String viewerRoomUrl, String endDate, String meetingId) {
        MeetingDetails meetingDetails = new MeetingDetails();
        meetingDetails.setBooking(booking);
        meetingDetails.setHostRoomUrl(hostRoomUrl);
        meetingDetails.setViewerRoomUrl(viewerRoomUrl);
        meetingDetails.setEndDate(endDate);
        meetingDetails.setMeetingId(meetingId);
        meetingDetailsRepository.save(meetingDetails);
    }

    public MeetingDetails deleteMeetingDetails(Long id) {
        MeetingDetails meetingDetails = meetingDetailsRepository.findById(id).orElseThrow();
        meetingDetailsRepository.delete(meetingDetails);
        return meetingDetails;
    }

    public MeetingDetails getMeetingDetailsById(Long id) {
        return meetingDetailsRepository.findById(id).orElseThrow();
    }

    public String getMeetingDetailsHostRoomUrl(Integer id) {
        return meetingDetailsRepository.findByBookingId(id).getHostRoomUrl();
    }

    public String getMeetingDetailsViewerRoomUrl(Integer id) {
        return meetingDetailsRepository.findByBookingId(id).getViewerRoomUrl();
    }

}