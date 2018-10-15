package com.lh.service;

import com.lh.bean.Notice;
import com.lh.bean.NoticeWithBLOBs;

import java.util.List;

public interface NoticeService {
    void add(NoticeWithBLOBs notice);
    void delete(int id);
    void update(NoticeWithBLOBs notice);
    Notice get(int id);
    NoticeWithBLOBs getBLOB(int id);
    List<Notice> list();
    List<Notice> listByStatus(int status);
    List<NoticeWithBLOBs> listBLOB();
}
