package com.enableets.edu.enable.cloud.exam.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 考试明细PO
 */
@Entity
@Table(name="exam_details_info")
public class ExamDetailsInfoPO {

    /**
     * 考试明细标识
     */
    @Column(name = "exam_details_id")
    private Long examDetailsId;

    /**
     * 考试标识
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 年级编码
     */
    @Column(name = "grade_code")
    private String gradeCode;

    /**
     * 年级名称
     */
    @Column(name = "grade_name")
    private String gradeName;

    /**
     * 班级标识
     */
    @Column(name = "class_id")
    private String classId;

    /**
     * 班级名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 学科代码
     */
    @Column(name = "subject_code")
    private String subjectCode;

    /**
     * 学科名称
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 课程标识
     */
    @Column(name = "course_id")
    private String courseId;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 文理科属性：理科;文科
     */
    @Column(name = "course_attribute")
    private String courseAttribute;

    /**
     * 考试时间
     */
    @Column(name = "exam_time")
    private Date examTime;

    /**
     * 计划考试学生数
     */
    @Column(name = "plan_student_number")
    private Integer planStudentNumber;

    /**
     * 实际考试学生数
     */
    @Column(name = "actual_student_number")
    private Integer actualStudentNumber;

    /**
     * 试卷总分
     */
    @Column(name = "total_score")
    private float totalScore;

    /**
     * 创建者
     */
    @Column(name = "creator")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改者
     */
    @Column(name = "updator")
    private String updator;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 考试名称
     */
    @Transient
    private String name;
    /**
     * 考试类型
     */
    @Transient
    private String type;
    
    /**
     * 考试类型代码
     */
    @Transient
    private String examTypeCode;

    @Transient
    private String schoolId;

    /**
     * 录分进度
     */
    @Transient
    private String progress;
    /**
     * 录分人数
     */
    @Transient
    private Integer count;
    /**
     * 录分老师
     */
    @Transient
    private String teacherFullName;

    /**
     * 录分老师集合
     */
    @Transient
    private List<ExamPointInputSettingPO> teacherList;
    
    @Transient
    private String termId;
    
    @Transient
    private String termName;
    
    @Transient
    private Integer studentNumber;
    
    @Transient
    private String excludeTermId;
    
    @Transient
    private String schoolYear;

    /**
     * 考试成绩集合
     */
    @Transient
    private List<ExamResultInfoPO> examResultInfoList;

    public List<ExamResultInfoPO> getExamResultInfoList() {
        return examResultInfoList;
    }

    public void setExamResultInfoList(List<ExamResultInfoPO> examResultInfoList) {
        this.examResultInfoList = examResultInfoList;
    }

    public Long getExamDetailsId() {
        return examDetailsId;
    }

    public void setExamDetailsId(Long examDetailsId) {
        this.examDetailsId = examDetailsId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAttribute() {
        return courseAttribute;
    }

    public void setCourseAttribute(String courseAttribute) {
        this.courseAttribute = courseAttribute;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Integer getPlanStudentNumber() {
        return planStudentNumber;
    }

    public void setPlanStudentNumber(Integer planStudentNumber) {
        this.planStudentNumber = planStudentNumber;
    }

    public Integer getActualStudentNumber() {
        return actualStudentNumber;
    }

    public void setActualStudentNumber(Integer actualStudentNumber) {
        this.actualStudentNumber = actualStudentNumber;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public List<ExamPointInputSettingPO> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<ExamPointInputSettingPO> teacherList) {
        this.teacherList = teacherList;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getExcludeTermId() {
		return excludeTermId;
	}

	public void setExcludeTermId(String excludeTermId) {
		this.excludeTermId = excludeTermId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getExamTypeCode() {
		return examTypeCode;
	}

	public void setExamTypeCode(String examTypeCode) {
		this.examTypeCode = examTypeCode;
	}
    
}
