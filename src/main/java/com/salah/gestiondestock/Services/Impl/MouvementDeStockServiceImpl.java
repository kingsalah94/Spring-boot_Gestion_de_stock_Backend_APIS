package com.salah.gestiondestock.Services.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.gestiondestock.Dtos.MouvementDeStockDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Enums.TypeMouvementStock;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.MouvementDeStockRepository;
import com.salah.gestiondestock.Services.ArticlesService;
import com.salah.gestiondestock.Services.MouvementStockService;
import com.salah.gestiondestock.Validators.MvtStkValidator;
import com.salah.gestiondestock.model.MouvementDeStock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MouvementDeStockServiceImpl implements MouvementStockService {
    
    private MouvementDeStockRepository repository;
  private ArticlesService articleService;

@Autowired
  public MouvementDeStockServiceImpl(MouvementDeStockRepository repository, ArticlesService articleService) {
    this.repository = repository;
    this.articleService = articleService;
  }



  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    if (idArticle == null) {
      log.warn("ID article is NULL");
      return BigDecimal.valueOf(-1);
    }
    articleService.findById(idArticle);
    return repository.stockReelArticle(idArticle);
  }

  @Override
  public List<MouvementDeStockDto> mvtStkArticle(Integer idArticle) {
    return repository.findAllByArticleId(idArticle).stream()
        .map(MouvementDeStockDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public MouvementDeStockDto entreeStock(MouvementDeStockDto dto) {
    return entreePositive(dto, TypeMouvementStock.ENTREE);
  }

  @Override
  public MouvementDeStockDto sortieStock(MouvementDeStockDto dto) {
    return sortieNegative(dto, TypeMouvementStock.SORTIE);
  }

  @Override
  public MouvementDeStockDto correctionStockPos(MouvementDeStockDto dto) {
    return entreePositive(dto, TypeMouvementStock.CORRECTION_POS);
  }

  @Override
  public MouvementDeStockDto correctionStockNeg(MouvementDeStockDto dto) {
    return sortieNegative(dto, TypeMouvementStock.CORRECTION_NEG);
  }

  private MouvementDeStockDto entreePositive(MouvementDeStockDto dto, TypeMouvementStock typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalideEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue())
        )
    );
    dto.setTypeMouvementStock(typeMvtStk);
    return MouvementDeStockDto.fromEntity(
        repository.save(MouvementDeStockDto.toEntity(dto))
    );
  }

  private MouvementDeStockDto sortieNegative(MouvementDeStockDto dto, TypeMouvementStock typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalideEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue()) * -1
        )
    );
    dto.setTypeMouvementStock(typeMvtStk);
    return MouvementDeStockDto.fromEntity(
        repository.save(MouvementDeStockDto.toEntity(dto))
    );
  }
}
