package br.com.food4fit.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.food4fit.dao.AcompanhamentoDAO;
import br.com.food4fit.dao.AlimentoDAO;
import br.com.food4fit.dao.CompraDAO;
import br.com.food4fit.dao.DadosSaudeDAO;
import br.com.food4fit.dao.DietaDAO;
import br.com.food4fit.dao.HidratacaoDAO;
import br.com.food4fit.dao.HistoricoAlimentacaoDAO;
import br.com.food4fit.dao.RefeicaoDAO;
import br.com.food4fit.dao.UsuarioDAO;
import br.com.food4fit.model.Alimento;
import br.com.food4fit.model.Compra;
import br.com.food4fit.model.DietaEntity;
import br.com.food4fit.model.HistoricoAlimentacao;
import br.com.food4fit.model.ItemAcompanhamento;
import br.com.food4fit.model.ItemDadosSaude;
import br.com.food4fit.model.ItemHidratacao;
import br.com.food4fit.model.RefeicaoEntity;
import br.com.food4fit.model.Usuario;

@Database(version = 20, entities = {Usuario.class, DietaEntity.class, RefeicaoEntity.class, Alimento.class, HistoricoAlimentacao.class, ItemAcompanhamento.class, ItemDadosSaude.class, ItemHidratacao.class, Compra.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract UsuarioDAO getUsuarioDAO();
    public abstract DietaDAO getDietaDAO();
    public abstract RefeicaoDAO getRefeicaoDAO();
    public abstract AlimentoDAO getAlimentoDAO();
    public abstract HistoricoAlimentacaoDAO getHistoricoAlimentacaoDAO();
    public abstract AcompanhamentoDAO getAcompanhamentoDAO();
    public abstract DadosSaudeDAO getDadosSaudeDAO();
    public abstract HidratacaoDAO getHidratacaoDAO();
    public abstract CompraDAO getCompraDAO();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "food4fit")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;
    }
}