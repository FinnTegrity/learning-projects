package com.trungtam.patterns.observer;
import java.util.*;
// Kenh su kien
public class KenhSuKien {
    private static final Map<String, java.util.List<SuKienLangNghe>> ds=new HashMap<>();
    public static void dangKy(String chuDe, SuKienLangNghe l){ ds.computeIfAbsent(chuDe,k->new ArrayList<>()).add(l); }
    public static void phat(String chuDe, Object duLieu){ for(SuKienLangNghe l: ds.getOrDefault(chuDe, java.util.Collections.emptyList())) l.khiCoSuKien(chuDe, duLieu); }
}
