package in.suvam.courseapidata.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.suvam.courseapidata.topic.Topic;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllTopics(@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicID}/courses/{id}")
    public Optional<Course> getTopic(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicID}/courses")
    public void addTopic(@RequestBody Course course, @PathVariable String topicID)
    {
        course.setTopic(new Topic(topicID, "", ""));
        courseService.addCourse(course);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicID}/courses/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String topicID)
    {
        course.setTopic(new Topic(topicID, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicID}/courses/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }
}
