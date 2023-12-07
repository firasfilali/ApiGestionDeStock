package com.filali.gestiodestock.dto;


import com.filali.gestiodestock.model.LigneCommandeFournisseur;
import com.filali.gestiodestock.model.MvtStk;
import com.filali.gestiodestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;
@Builder
@Data
public class MvtStkDto {
    private Integer id;
    private Instant dateMvt;

    private BigDecimal quantite;
    private ArticleDto article;
    private TypeMvtStk typeMvt;
    private Integer idEntreprise;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk == null){
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .quantite(mvtStk.getQuantite())
                .dateMvt(mvtStk.getDateMvt())
                .typeMvt(mvtStk.getTypeMvt())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
        mvtStk.setIdEntreprise(mvtStkDto.getIdEntreprise());

        return mvtStk;

    }
}
