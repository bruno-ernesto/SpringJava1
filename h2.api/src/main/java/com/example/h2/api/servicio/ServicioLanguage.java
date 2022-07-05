package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Language;
import java.util.Optional;
public interface ServicioLanguage {
    Language guardarLanguage(Language language);
    Optional<Language> obtenerLanguage(Long id);
    Language languageAModificar(Long id,Language languageModificar);
    boolean eliminarLanguage(Long id);
}
