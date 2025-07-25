/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.salah.gestiondestock.Services;

import java.math.BigDecimal;
import java.util.List;

import com.salah.gestiondestock.Dtos.MouvementDeStockDto;

/**
 *
 * @author bahac
 */
public interface MouvementStockService {

    BigDecimal stockReelArticle(Integer idArticle);

    List<MouvementDeStockDto> mvtStkArticle(Integer idArticle);

    MouvementDeStockDto entreeStock(MouvementDeStockDto dto);

    MouvementDeStockDto sortieStock(MouvementDeStockDto mapper);

    MouvementDeStockDto correctionStockPos(MouvementDeStockDto dto);

    MouvementDeStockDto correctionStockNeg(MouvementDeStockDto dto);

}
