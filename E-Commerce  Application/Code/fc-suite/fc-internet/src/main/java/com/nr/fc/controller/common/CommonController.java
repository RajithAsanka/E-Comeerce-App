package com.nr.fc.controller.common;

///*
// * To change this license header, choose License Headers in Project Properties. To change this
// * template file, choose Tools | Templates and open the template in the editor.
// */
//package com.nr.fc.controller.common;
//
//import com.nr.fc.enums.GeneralStatus;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.nr.fc.json.model.scholarshipCodeForTypeJson;
//import com.nr.fc.json.options.SelectOption;
//import com.nr.fc.model.AchivementType;
//import com.nr.fc.model.ActivityType;
//import com.nr.fc.model.AreaOfExpertise;
//import com.nr.fc.model.AreaOfExpertiseActivity;
//import com.nr.fc.model.AssignmentHomework;
//import com.nr.fc.model.AssignmentHomeworkType;
//import com.nr.fc.model.AttachmentType;
//import com.nr.fc.model.Batch;
//import com.nr.fc.model.BatchCategory;
//import com.nr.fc.model.BatchTemplate;
//import com.nr.fc.model.City;
//import com.nr.fc.model.ClassId;
//import com.nr.fc.model.ClassRoom;
//import com.nr.fc.model.Country;
//import com.nr.fc.model.Course;
//import com.nr.fc.model.CourseCategory;
//import com.nr.fc.model.CourseModule;
//import com.nr.fc.model.Department;
//import com.nr.fc.model.DepartmentType;
//import com.nr.fc.model.DonorScholarshipLink;
//import com.nr.fc.model.EducationQualificationType;
//import com.nr.fc.model.Employee;
//import com.nr.fc.model.EmployeeCategory;
//import com.nr.fc.model.EmployeeModuleLink;
//import com.nr.fc.model.EventType;
//import com.nr.fc.model.Exam;
//import com.nr.fc.model.ExamType;
//import com.nr.fc.model.HolidayCategeory;
//import com.nr.fc.model.Institute;
//import com.nr.fc.model.InstituteType;
//import com.nr.fc.model.InternshipOrganization;
//import com.nr.fc.model.JobTitle;
//import com.nr.fc.model.Language;
//import com.nr.fc.model.Level;
//import com.nr.fc.model.LevelStudentLink;
//import com.nr.fc.model.Module;
//import com.nr.fc.model.ModuleCategory;
//import com.nr.fc.model.Nationality;
//import com.nr.fc.model.Province;
//import com.nr.fc.model.Religion;
//import com.nr.fc.model.ReportingTo;
//import com.nr.fc.model.ScholarshipDetail;
//import com.nr.fc.model.ScholarshipDonorDetial;
//import com.nr.fc.model.ScholarshipType;
//import com.nr.fc.model.Semester;
//import com.nr.fc.model.SiblingType;
//import com.nr.fc.model.Student;
//import com.nr.fc.model.StudentCategory;
//import com.nr.fc.model.StudentHouse;
//import com.nr.fc.model.TimetableModuleLink;
//import com.nr.fc.model.UserCategory;
//import com.nr.fc.model.UserType;
//import com.nr.fc.service.AchievementTypeService;
//import com.nr.fc.service.ActivityTypeService;
//import com.nr.fc.service.AreaOfExpertiseActivityService;
//import com.nr.fc.service.AreaOfExpertiseService;
//import com.nr.fc.service.AssignmentHomeworkService;
//import com.nr.fc.service.AssignmentHomeworkTypeService;
//import com.nr.fc.service.program.BatchCategoryService;
//import com.nr.fc.service.AttachmentTypeService;
//import com.nr.fc.service.program.BatchService;
//import com.nr.fc.service.CityService;
//import com.nr.fc.service.ClassIdService;
//import com.nr.fc.service.ClassRoomService;
//import com.nr.fc.service.CountryService;
//import com.nr.fc.service.program.CourseCategoryService;
//import com.nr.fc.service.program.CourseModuleService;
//import com.nr.fc.service.program.CourseService;
//import com.nr.fc.service.DepartmentService;
//import com.nr.fc.service.DepartmentTypeService;
//import com.nr.fc.service.EducationQualificationTypeService;
//import com.nr.fc.service.employee.EmployeeCategoryService;
//import com.nr.fc.service.employee.EmployeeModuleService;
//import com.nr.fc.service.employee.EmployeeService;
//import com.nr.fc.service.EventTypeService;
//import com.nr.fc.service.ExamService;
//import com.nr.fc.service.ExamTypeService;
//import com.nr.fc.service.HolidayCategoryService;
//import com.nr.fc.service.InstituteService;
//import com.nr.fc.service.InstituteTypeService;
//import com.nr.fc.service.InternshipOrganizationService;
//import com.nr.fc.service.JobTitleService;
//import com.nr.fc.service.LanguageService;
//import com.nr.fc.service.LevelStudentLinkService;
//import com.nr.fc.service.program.LevelService;
//import com.nr.fc.service.program.ModuleCategoryService;
//import com.nr.fc.service.program.ModuleService;
//import com.nr.fc.service.NationalityService;
//import com.nr.fc.service.ProvinceService;
//import com.nr.fc.service.ReligionService;
//import com.nr.fc.service.ReportingToService;
//import com.nr.fc.service.ScholarshipDetailService;
//import com.nr.fc.service.ScholarshipDonorDetialService;
//import com.nr.fc.service.ScholarshipDonorLinkService;
//import com.nr.fc.service.ScholarshipTypeService;
//import com.nr.fc.service.program.SemesterService;
//import com.nr.fc.service.SiblingTypeService;
//import com.nr.fc.service.TimetableModuleLinkService;
//import com.nr.fc.service.program.BatchTemplateService;
//import com.nr.fc.service.student.StudentCategoryService;
//import com.nr.fc.service.student.StudentClassLinkService;
//import com.nr.fc.service.student.StudentHouseService;
//import com.nr.fc.service.student.StudentService;
//import com.nr.fc.service.user.UserCategoryService;
//import com.nr.fc.service.user.UserTypeService;
//import com.nr.fc.util.DateUtil;
//import com.nr.fc.util.DateUtil.Formats;
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// *
// * @author User
// */
//@Controller
//public class CommonController {
//    
//    @Autowired
//    private CountryService countryService;
//    @Autowired
//    private CityService cityService;
//    @Autowired
//    private ProvinceService provinceService;
//    
//    @Autowired
//    private CourseModuleService courseModuleService;
//    
//    @Autowired
//    private ScholarshipDonorDetialService scholarshipDonarDetialService;
//    
//    @Autowired
//    private ScholarshipDetailService scholarshipDetailService;
//    
//    @Autowired
//    private ClassRoomService classRoomService;
//    
//    @Autowired
//    private ScholarshipDonorLinkService scholarshipDonorLinkService;
//    
//    @Autowired
//    private CourseCategoryService courseCategoryService;
//    
//    @Autowired
//    private CourseService courseService;
//    
//    @Autowired
//    private NationalityService nationalityService;
//    
//    @Autowired
//    private ReligionService religionService;
//    
//    @Autowired
//    private LanguageService languageService;
//    
//    @Autowired
//    private DepartmentService departmentService;
//    
//    @Autowired
//    private DepartmentTypeService departmentTypeService;
//    
//    @Autowired
//    private EmployeeCategoryService employeeCategoryService;
//    
//    @Autowired
//    private AchievementTypeService achievementTypeService;
//    
//    @Autowired
//    private ActivityTypeService activityTypeService;
//    
//    @Autowired
//    private BatchCategoryService batchCategoryService;
//    
//    @Autowired
//    private AttachmentTypeService attachmentTypeService;
//    
//    @Autowired
//    private BatchService batchService;
//    
//    @Autowired
//    private ClassIdService classIdService;
//    
//    @Autowired
//    private EducationQualificationTypeService educationQualificationTypeService;
//    
//    @Autowired
//    private ScholarshipTypeService scholarshipTypeService;
//    
//    @Autowired
//    private SiblingTypeService siblingTypeService;
//    
//    @Autowired
//    private StudentCategoryService studentCategoryService;
//    
//    @Autowired
//    private JobTitleService jobTitleService;
//    
//    @Autowired
//    private InstituteService instituteService;
//    
//    @Autowired
//    private AreaOfExpertiseService areaOfExpertiseService;
//    
//    @Autowired
//    private AreaOfExpertiseActivityService employeeAreaOfExpertiseActivityService;
//    
//    @Autowired
//    private ModuleCategoryService moduleCategoryService;
//    
//    @Autowired
//    private InternshipOrganizationService internshipOrganizationService;
//    
//    @Autowired
//    private LevelService levelService;
//    
//    @Autowired
//    private EmployeeService employeeService;
//    
//    @Autowired
//    private EmployeeModuleService employeeModuleService;
//    
//    @Autowired
//    private ModuleService moduleService;
//    
//    @Autowired
//    private SemesterService semesterService;
//    
//    @Autowired
//    private ReportingToService reportingToService;
//    
//    @Autowired
//    private BatchTemplateService batchTemplateService;
//    
//    @Autowired
//    private LevelStudentLinkService levelStudentLinkService;
//    
//    @Autowired
//    private StudentClassLinkService classLinkService;
//    
//    @Autowired
//    InstituteTypeService instituteTypeService;
//    
//    @Autowired
//    private HolidayCategoryService holidayCategoryService;
//    
//    @Autowired
//    private EventTypeService eventTypeService;
//    
//    @Autowired
//    private TimetableModuleLinkService timetableModuleLinkService;
//    
//    @Autowired
//    private ExamTypeService examTypeService;
//    
//    @Autowired
//    private ExamService examService;
//    
//    @Autowired
//    private StudentService studentService;
//    
//    @Autowired
//    private UserTypeService userTypeService;
//    
//    @Autowired
//    private UserCategoryService userCategoryService;
//    
//    @Autowired
//    private AssignmentHomeworkTypeService assignmentHomeworkTypeService;
//    
//    @Autowired
//    private AssignmentHomeworkService assignmentHomeworkService;
//    
//    @Autowired
//    private StudentHouseService studentHouseService;
//    
//    @RequestMapping(value = "admin/getOrganizationList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getOrganizationList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (InternshipOrganization internshipOrganization : internshipOrganizationService.findAll()) {
//            list.add(new SelectOption(internshipOrganization.getOrganizationId(), internshipOrganization.getOrganizationName()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/countryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public List<SelectOption> countryList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Country country : countryService.findAll()) {
//            list.add(new SelectOption(country.getCountryId(), country.getCountryId()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/provinceList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> provinceList(@RequestParam("countryId") String countryCode) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Province province : provinceService.findByCountry(countryService.findByCountryCode(countryCode))) {
//            
//            list.add(new SelectOption(province.getProvincePK().getProvinceId(), province.getProvincePK().getProvinceId()));
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/cityList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> cityList(@RequestParam("provinceId") String provinceCode) {
//        List<SelectOption> list = new ArrayList<>();
//        for (City city : cityService.findByProvince(provinceCode)) {
//            if (city.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(city.getCityPK().getCityId(), city.getCityPK().getCityId()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/courseCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> courseCategoryList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (CourseCategory courseCategory : courseCategoryService.findAll()) {
//            if (courseCategory.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(courseCategory.getCourseCategory(), courseCategory.getCourseCategory()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/courseList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> courseList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Course course : courseService.findAll()) {
//            if (course.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(course.getCourseId(), course.getCourseName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/nationalityList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> nationalityList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Nationality nationality : nationalityService.findAll()) {
//            if (nationality.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(nationality.getNationalityId(), nationality.getNationalityId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/religionList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> religionList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Religion religion : religionService.findAll()) {
//            if (religion.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(religion.getReligionId(), religion.getReligionId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/languageList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> languageList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Language language : languageService.findAll()) {
//            if (language.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(language.getLanguageId(), language.getLanguageId()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/departmentList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> departmentList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Department department : departmentService.findAll()) {
//            if (department.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(department.getDepartmentId(), department.getDepartmentId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/departmentTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> departmentTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (DepartmentType departmentType : departmentTypeService.getAllDepartmentList()) {
//            if (departmentType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(departmentType.getDepartmentType(), departmentType.getDepartmentType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/employeeCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> employeeCatogeryList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (EmployeeCategory category : employeeCategoryService.findAll()) {
//            if (category.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(category.getEmployeeCategoryId(), category.getEmployeeCategoryId()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/achievementTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> achievementTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (AchivementType achivementType : achievementTypeService.getAllAchivementTypeList()) {
//            if (achivementType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(achivementType.getAchivementType(), achivementType.getAchivementType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/activityTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> activityTypeList() {
//        
//        List<SelectOption> list = new ArrayList<>();
//        for (ActivityType activityType : activityTypeService.getAllActivityList()) {
//            if (activityType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(activityType.getActivityType(), activityType.getActivityType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/attachmentTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> attachmentTypeList() {
//        
//        List<SelectOption> list = new ArrayList<>();
//        for (AttachmentType attachmentType : attachmentTypeService.getAllAttachemntList()) {
//            if (attachmentType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(attachmentType.getAttachmentType(), attachmentType.getAttachmentType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/batchList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> batchList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Batch batch : batchService.findAll()) {
//            if (batch.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(batch.getBatchPK().getBatchId(), batch.getBatchName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/classList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> classList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (ClassId classId : classIdService.findAll()) {
//            if (classId.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(classId.getClassId(), classId.getClassName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/educationQualificationTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> educationQualificationTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (EducationQualificationType educationQualificationType : educationQualificationTypeService.findAll()) {
//            if (educationQualificationType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(educationQualificationType.getQualificationTypeId(), educationQualificationType.getQualificationTypeId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/scholarshipTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> scholarshipTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (ScholarshipType scholarshipType : scholarshipTypeService.findAll()) {
//            if (scholarshipType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(scholarshipType.getScholarshipType(), scholarshipType.getScholarshipType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/scholarshipCodeForType", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> scholarshipCodeForTypeList(@RequestParam("id") String id) throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        for (DonorScholarshipLink donorScholarshipLink : scholarshipDonorLinkService.findByType(id)) {
//            ScholarshipDonorDetial obj = scholarshipDonarDetialService.findById(donorScholarshipLink.getDonorScholarshipLinkPK().getDonorId());
//            scholarshipDonarDetialService.findById(donorScholarshipLink.getDonorScholarshipLinkPK().getDonorId());
//            donorScholarshipLink.getDonorScholarshipLinkPK().getDonorId();
//            scholarshipCodeForTypeJson typeJson = new scholarshipCodeForTypeJson();
//            
//            typeJson.setDonorId(donorScholarshipLink.getDonorScholarshipLinkPK().getDonorId());
//            typeJson.setEndDate(DateUtil.dateToString(donorScholarshipLink.getScholarshipDetail().getScholarshipEndDate(), Formats.DEFAULTDATE));
//            typeJson.setStartDate(DateUtil.dateToString(donorScholarshipLink.getScholarshipDetail().getScholarshipStartDate(), Formats.DEFAULTDATE));
//            typeJson.setScholarshipCode(donorScholarshipLink.getDonorScholarshipLinkPK().getScholarshipCode());
//            typeJson.setScholarshipType(donorScholarshipLink.getDonorScholarshipLinkPK().getScholarshipType());
//            
//            list.add(new SelectOption(typeJson, obj.getFirstName() + " " + obj.getLastName()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/sponsorNameForType", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> sponsorNameForTypeList(@RequestParam("id") String id) {
//        List<SelectOption> list = new ArrayList<>();
//        for (DonorScholarshipLink donorScholarshipLink : scholarshipDonorLinkService.findByType(id)) {
//            list.add(new SelectOption(donorScholarshipLink.getDonorScholarshipLinkPK(), donorScholarshipLink.getDonorScholarshipLinkPK().getScholarshipCode()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/scholarshipCodeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> scholarshipCodeList() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        for (ScholarshipDetail scholarshipDetail : scholarshipDetailService.findAll()) {
//            list.add(new SelectOption(scholarshipDetail.getScholarshipDetailPK().getScholarshipCode(), scholarshipDetail.getScholarshipDetailPK().getScholarshipCode()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/scholarshipCodeIdList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> scholarshipCodeIdList() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        for (ScholarshipDetail scholarshipDetail : scholarshipDetailService.findAll()) {
//            list.add(new SelectOption(scholarshipDetail.getScholarshipDetailPK(), scholarshipDetail.getScholarshipDetailPK().getScholarshipCode()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/sponsorDetailsList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> sponsorDetailsList() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        for (ScholarshipDonorDetial scholarshipDonorDetial : scholarshipDonarDetialService.findAll()) {
//            if (scholarshipDonorDetial.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(scholarshipDonorDetial.getDonorId(), scholarshipDonorDetial.getFirstName() + " " + scholarshipDonorDetial.getLastName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/siblingTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> siblingTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (SiblingType siblingType : siblingTypeService.findAll()) {
//            if (siblingType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(siblingType.getSiblingType(), siblingType.getSiblingType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/studentCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> studentCategoryList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (StudentCategory studentCategory : studentCategoryService.getAllstudentCategoryList()) {
//            if (studentCategory.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(studentCategory.getStudentCategoryId(), studentCategory.getStudentCategoryId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/employeeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> employeeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Employee employee : employeeService.findAll()) {
//            if (employee.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(employee.getEmployeeId(), employee.getFirstName()));
//            }
//        }
//        return list;
//        
//    }
//    
//    @RequestMapping(value = "/admin/classHeadList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> classHeadList(@RequestParam(value = "classId", required = false) String classId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Student student : classLinkService.findStudentsByClassId(classId)) {
//            if (student.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(student.getStudentId(), student.getFirstName() + " " + student.getLastName()));
//            }
//        }
//        return list;
//        
//    }
//    
//    @RequestMapping(value = "/admin/reportingEmployeeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> reportingEmployeeList() {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (ReportingTo reportingTo : reportingToService.findbyAll()) {
//            if (reportingTo.getStatus().equalsIgnoreCase("Active")) {
//                Employee employee = employeeService.findByEmployeeId(reportingTo.getEmployeeId());
//                list.add(new SelectOption(employee.getEmployeeId(), employee.getFirstName()));
//            }
//            
//        }
//        
//        return list;
//        
//    }
//    
//    @RequestMapping(value = "/admin/jotTitleList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> jotTitleList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (JobTitle jobTitle : jobTitleService.getAllJobTitleList()) {
//            if (jobTitle.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(jobTitle.getJobTitle(), jobTitle.getJobTitle()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/institueList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> institueList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Institute institute : instituteService.findAllAsc()) {
//            if (institute.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(institute.getInstituteId(), institute.getName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/levelList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> levelList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Level level : levelService.findAll()) {
//            if (level.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(level.getLevelId(), level.getLevelName()));
//            }
//        }
//        return list;
//    }
//
//    /**
//     *
//     * @return
//     */
//    @RequestMapping(value = "/admin/areaOfExpertiseList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> areaOfExpertiseList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (AreaOfExpertise area : areaOfExpertiseService.findAll()) {
//            if (area.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(area.getAreaOfExpertise(), area.getAreaOfExpertise()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/areaOfExpertiseActivityList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> areaOfExpertiseActivityList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (AreaOfExpertiseActivity area : employeeAreaOfExpertiseActivityService.findAll()) {
//            if (area.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(area.getAreaOfExpertiseActivity(), area.getAreaOfExpertiseActivity()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/moduleCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> moduleCategoryList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (ModuleCategory moduleCategory : moduleCategoryService.findAll()) {
//            if (moduleCategory.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(moduleCategory.getModuleCategory(), moduleCategory.getModuleCategory()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/employeeModuleList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> employeeModuleList(@RequestParam("moduleId") String moduleId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (EmployeeModuleLink employeeModuleLink : employeeModuleService.findByModuleId(moduleId)) {
//            if (employeeModuleLink.getStatus().equalsIgnoreCase("Active")) {
//                Employee employee = employeeService.findByEmployeeId(employeeModuleLink.getEmployeeModuleLinkPK().getEmployeeId());
//                list.add(new SelectOption(employeeModuleLink.getEmployeeModuleLinkPK().getEmployeeId(), employee.getFirstName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/moduleList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> moduleList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (CourseModule module : courseModuleService.findNotDeactive()) {
//            if (module.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(module.getCourseModuleId(), module.getModuleName()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getModuleOptionsByCourseAndBatchAndLevel", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> moduleListByBatchTemplate(
//            @RequestParam(value = "courseId", required = false) String courseId,
//            @RequestParam(value = "batchId", required = false) String batchId,
//            @RequestParam(value = "levelId", required = false) String levelId
//    ) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Module module : batchTemplateService.findLevlBatchID(courseId, batchId, levelId)) {
//            if (module.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(module.getModuleId(), module.getModuleName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/semesterList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> semesterList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Semester semester : semesterService.findAll()) {
//            if (semester.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(semester.getSemesterPK().getSemesterId(), semester.getSemesterPK().getSemesterId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getLevelSemesterList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> semesterListById(@RequestParam("levelId") String levelid) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Semester semester : semesterService.findByLevelId(levelid)) {
//            if (semester.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(semester.getSemesterPK().getSemesterId(), semester.getName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getModuleById", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getModuleByProgramId(@RequestParam("programId") String programId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (CourseModule coursemodule : courseModuleService.findModuleByProgramCatageory(programId)) {
//            if (coursemodule.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(coursemodule.getCourseModuleId(), coursemodule.getCourseModuleId() + " / " + coursemodule.getModuleName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/batchCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> batchCategoryList() {
//        
//        List<SelectOption> list = new ArrayList<>();
//        for (BatchCategory batchCategory : batchCategoryService.findAll()) {
//            if (batchCategory.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(batchCategory.getBatchCategory(), batchCategory.getBatchCategory()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/batchNamesByList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> batchNamesByList(@RequestParam("programId") String programId) {
//        
//        List<SelectOption> list = new ArrayList<>();
//        for (Batch batch : batchService.findBatchNamesByProgramId(programId)) {
//            list.add(new SelectOption(batch.getBatchPK().getBatchId(), batch.getBatchName()));
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/levelsByBathName", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> levelsByBathName(@RequestParam("batchId") String batchid) {
//        List<SelectOption> list = new ArrayList<>();
//        Batch batch = batchService.findByBatchId(batchid);
//        if (batch != null) {
//            for (BatchTemplate batchTemplate : batchTemplateService.findByBatchId(batch.getBatchPK().getBatchId())) {
//                
//                list.add(new SelectOption(batchTemplate.getLevelId().getLevelId(), batchTemplate.getLevelId().getLevelName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/classListByBatchName", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> classListByBatchName(@RequestParam("batchId") String batchid) {
//        List<SelectOption> list = new ArrayList<>();
//        for (ClassId classId : classIdService.findClassByBatchId(batchid)) {
//            if (classId.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(classId.getClassId(), classId.getClassName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getlevelListByClassId", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> levelListByBatchNameAndClassId(@RequestParam("classId") String classId) {
//        List<SelectOption> list = new ArrayList<>();
//        ClassId classobj = classIdService.findByClassId(classId);
//        if (classobj != null) {
//            
//            List<LevelStudentLink> levelStudentLink = levelStudentLinkService.findByClassId(classId);
//            Level level = levelService.findbyId(levelStudentLink.get(0).getLevelId().getLevelId());
//            List<BatchTemplate> batchTemplate = batchTemplateService.findByBatchId(classobj.getBatch().getBatchPK().getBatchId());
//            
//            for (BatchTemplate batchTemplate1 : batchTemplate) {
//                if (!level.getLevelId().equals(batchTemplate1.getLevelId().getLevelId())) {
//                    list.add(new SelectOption(batchTemplate1.getLevelId().getLevelId(), batchTemplate1.getLevelId().getLevelName()));
//                }
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/instituteTypes", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getInstituteTypes() {
//        List<SelectOption> list = new ArrayList<>();
//        for (InstituteType instituteType : instituteTypeService.findAll()) {
//            if (instituteType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(instituteType.getInstituteTypeId(), instituteType.getInstituteTypeId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/holidayCategoryTypes", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getHolidayCategoryTypes() {
//        List<SelectOption> list = new ArrayList<>();
//        for (HolidayCategeory holidayCategeory : holidayCategoryService.findAll()) {
//            if (holidayCategeory.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(holidayCategeory.getHolidayCategory(), holidayCategeory.getHolidayCategory()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/eventTypes", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getEventTypes() {
//        List<SelectOption> list = new ArrayList<>();
//        for (EventType eventType : eventTypeService.findAll()) {
//            if (eventType.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(eventType.getEventType(), eventType.getEventType()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getModulesByLevelAndSemester", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> moduleListByLevelIdANDSemesterID(@RequestParam("programId") String programId, @RequestParam("levelId") String levelId, @RequestParam("semesterId") String semesterId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Module module : moduleService.findByProgramIdANDLevelIdANDSemesterId(programId, levelId, semesterId)) {
//            
//            if (module.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(module.getModuleId(), module.getModuleName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getModulesByTimeTbleIdAndDay", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public List<SelectOption> findModulesByTimeTbleIdAndDay(@RequestParam(value = "timetableId", required = false) String timetableId, @RequestParam(value = "dayofWeek", required = false) String dayofWeek) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (TimetableModuleLink timetableModuleLink : timetableModuleLinkService.findMoulesByTimeTableIdAndDayofWeek(timetableId, dayofWeek)) {
//            
//            list.add(new SelectOption(timetableModuleLink.getModuleId().getModuleId(), timetableModuleLink.getModuleId().getModuleName()));
//            
//        }
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getPeriodsByDayOfWeek", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public List<SelectOption> findPeriodsByDayOfWeek(@RequestParam(value = "timetableId", required = false) String timetableId, @RequestParam(value = "dayofWeek", required = false) String dayofWeek) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (TimetableModuleLink timetableModuleLink : timetableModuleLinkService.findMoulesByTimeTableIdAndDayofWeek(timetableId, dayofWeek)) {
//            
//            String start = DateUtil.dateToString(timetableModuleLink.getModuleStartTime(), Formats.TWENTYFOURHOURS);
//            String end = DateUtil.dateToString(timetableModuleLink.getModuleEndTime(), Formats.TWENTYFOURHOURS);
//            
//            String period = start + " - " + end;
//            if (timetableModuleLink.getModuleId() != null && timetableModuleLink.getModuleType().equals("Module")) {
//                
//                list.add(new SelectOption(timetableModuleLink.getModuleId().getModuleId(), period));
//                
//            }
//            
//        }
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getModulesByProgramLevelBatchId", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    
//    List<SelectOption> moduleListByProgramLevelBatchId(@RequestParam("programId") String programId,
//            @RequestParam("levelId") String levelId,
//            @RequestParam("batchId") String batchId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Module module : batchTemplateService.findLevlBatchID(programId, batchId, levelId)) {
//            
//            if (module.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(module.getModuleId(), module.getCourseModuleId().getCourseModuleId() + "/" + module.getModuleName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/studentList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getStudentList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (Student student : studentService.findAll()) {
//            if (student.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(student.getStudentId(), student.getFirstName() + "/" + student.getStudentId()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getUserTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getUserTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (UserType userType : userTypeService.findAll()) {
//            if (userType.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(userType.getUserType(), userType.getUserType()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getUserCategoryList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getUserCategoryList(@RequestParam("userTypeId") String userTypeId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (UserCategory userCategory : userCategoryService.findByUserType(userTypeId)) {
//            if (userCategory.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(userCategory.getUserCategoryPK().getUserCategory(), userCategory.getUserCategoryPK().getUserCategory()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/examTypeList", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> examTypeList() {
//        List<SelectOption> list = new ArrayList<>();
//        for (ExamType examType : examTypeService.findAll()) {
//            if (examType.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(examType.getExamType(), examType.getExamTypeName()));
//                
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getExamTypesByCourseAndBatch", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getExamTypesByCourseAndBatch(@RequestParam("courseId") String courseId, @RequestParam("batchId") String batchId) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (ExamType examType : examTypeService.findByCourseAndBatch(courseId, batchId)) {
//            
//            list.add(new SelectOption(examType.getExamType(), examType.getExamTypeName() + "-" + examType.getLevelName()));
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getExamByCourseAndBatch", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getExamByCourseAndBatch(@RequestParam("courseId") String courseId, @RequestParam("batchId") String batchId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Exam exam : examService.findByCourseAndBatch(courseId, batchId)) {
//            if (exam.getStatus().equals(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(exam.getExamId(), exam.getExamName() + "-" + exam.getExamType().getSemester().getName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getClassRooms", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getClassRooms() {
//        List<SelectOption> list = new ArrayList<>();
//        for (ClassRoom classRoom : classRoomService.findAll()) {
//            if (classRoom.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(classRoom.getClassRoomId(), classRoom.getClassRoomName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getLevelsByCourseAndBatch", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getLevelsByCourseAndBatch(@RequestParam("courseId") String courseId, @RequestParam("batchId") String batchId) {
//        List<SelectOption> list = new ArrayList<>();
//        for (Level level : levelService.findByCourseANDBatch(courseId, batchId)) {
//            if (level.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(level.getLevelId(), level.getLevelName()));
//            }
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getAssignmentTypesByCourseAndBatch", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getAssignmentTypesByCourseAndBatch(@RequestParam("courseId") String courseId, @RequestParam("batchId") String batchId) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (AssignmentHomeworkType assignmentHomeworkType : assignmentHomeworkTypeService.findByCourseAndBatch(courseId, batchId)) {
//            
//            list.add(new SelectOption(assignmentHomeworkType.getAssignmentType(), assignmentHomeworkType.getAssignmentTypeName() + "-" + assignmentHomeworkType.getLevelName()));
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getClassesByCourseAndBatchAndLevel", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getClassesByCourseAndBatchAndLevel(@RequestParam("courseId") String courseId,
//            @RequestParam("batchId") String batchId, @RequestParam("levelId") String levelId) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (ClassId classId : classIdService.findClassByBatchIdAndLevelId(batchId, levelId)) {
//            
//            list.add(new SelectOption(classId.getClassId(), classId.getClassName()));
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getAssignmentTypes", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getAssignmentTypes() {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (AssignmentHomeworkType assignmentHomeworkType : assignmentHomeworkTypeService.findAll()) {
//            if (assignmentHomeworkType.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(assignmentHomeworkType.getAssignmentType(), assignmentHomeworkType.getAssignmentTypeName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getAssignmentByClassID", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getAssignmentByClassID(@RequestParam("classId") String classId) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (AssignmentHomework assignmentHomework : assignmentHomeworkService.findByCourseAndClassID(classId)) {
//            if (assignmentHomework.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(assignmentHomework.getAssignmentId(), assignmentHomework.getAssignmentName() + "-" + assignmentHomework.getAssignmentType().getSemester().getName()));
//            }
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getClassesByStudentAndBatch", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getClassesByStudentAndBatch(@RequestParam("batchId") String batchId, @RequestParam("studentId") String studentId) {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (ClassId classId : classLinkService.findClassesByStudentAndBatchId(batchId, studentId)) {
//            
//            list.add(new SelectOption(classId.getClassId(), classId.getClassName()));
//            
//        }
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/getStudentHouses", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getStudentHouses() {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (StudentHouse studentHouse : studentHouseService.findAllStudentHouses()) {
//            if (studentHouse.getStatus().equalsIgnoreCase(GeneralStatus.ACTIVE)) {
//                list.add(new SelectOption(studentHouse.getHouseName(), studentHouse.getHouseName()));
//            }
//            
//        }
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/receptionReport", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getreceptionReport() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("receptionReportMid"), props.getProperty("receptionReportMid")));
//        list.add(new SelectOption(props.getProperty("receptionReportEnd"), props.getProperty("receptionReportEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/nurseryReport", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getNurseryReport() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("nurseryFinalReportMid"), props.getProperty("nurseryFinalReportMid")));
//        list.add(new SelectOption(props.getProperty("nurseryFinalReporteEnd"), props.getProperty("nurseryFinalReporteEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/finalReportOneandTwo", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getfinalReportOneandTwo() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("finalReportOneTwoMid"), props.getProperty("finalReportOneTwoMid")));
//        list.add(new SelectOption(props.getProperty("finalReportOneTwoEnd"), props.getProperty("finalReportOneTwoEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/finalReportThreeSix", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getfinalReportThreeSix() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("finalReportThreeSixMid"), props.getProperty("finalReportThreeSixMid")));
//        list.add(new SelectOption(props.getProperty("finalReportThreeSixEnd"), props.getProperty("finalReportThreeSixEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/ealReportOneSix", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getealReportOneSix() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("ealReportOneSixMid"), props.getProperty("ealReportOneSixMid")));
//        list.add(new SelectOption(props.getProperty("ealReportOneSixEnd"), props.getProperty("ealReportOneSixEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/ealReportSevenThirteen", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> getealReportSevenThirteen() throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        Properties props = new Properties();
//        InputStream input = getClass().getClassLoader().getResourceAsStream("report.properties");
//        props.load(input);
//        
//        list.add(new SelectOption(props.getProperty("ealReportSevenThirteenMid"), props.getProperty("ealReportSevenThirteenMid")));
//        list.add(new SelectOption(props.getProperty("ealReportSevenThirteenEnd"), props.getProperty("ealReportSevenThirteenEnd")));
//        
//        return list;
//    }
//    
//    @RequestMapping(value = "/admin/secondaryReportSubjects", method = RequestMethod.GET, headers = "Accept=application/json")
//    public @ResponseBody
//    List<SelectOption> findModulesForSecondaryReport(@RequestParam("courseId") String courseId) throws Exception {
//        List<SelectOption> list = new ArrayList<>();
//        
//        for (CourseModule module : courseModuleService.findModulesForSecondaryReport(courseId)) {
//            if (module.getStatus().equalsIgnoreCase("Active")) {
//                list.add(new SelectOption(module.getCourseModuleId(), module.getModuleName()));
//                
//            }
//        }
//        return list;
//    }
//    
//}
//
//// ##########################################
//
