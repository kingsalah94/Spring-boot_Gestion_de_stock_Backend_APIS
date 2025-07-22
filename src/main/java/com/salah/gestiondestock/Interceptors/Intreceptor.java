/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.salah.gestiondestock.Interceptors;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;

import org.springframework.util.StringUtils;

/**
 *
 * @author bahac
 */
public class Intreceptor extends EmptyInterceptor {

  public String onPrepareStatement(String sql) {
    if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
      // select utilisateu0_.
      final String entityName = sql.substring(7, sql.indexOf("."));
      final String idEntreprise = MDC.get("idEntreprise");
      if (entityName != null
          && !entityName.toLowerCase().contains("entreprise")
          && !entityName.toLowerCase().contains("roles")
          && idEntreprise != null && !idEntreprise.isEmpty()) {

        if (sql.contains("where")) {
          sql = sql + " and " + entityName + ".identreprise = " + idEntreprise;
        } else {
          sql = sql + " where " + entityName + ".identreprise = " + idEntreprise;
        }
      }
    }
    return sql;
  }

}
