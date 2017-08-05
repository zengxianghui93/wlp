package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ReportDao;
import com.DBM.domain.Report;

@Service
public class ReportService {
 @Autowired
 ReportDao reportDao;
 public void update(Report report){
	 reportDao.update(report);
 }
 public Report getReport(){
	 List<Report> list = reportDao.loadAll();
	 if (list.isEmpty()) {
		return null;
	 }
	 return list.get(0);
 }
}
