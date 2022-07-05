package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Employee;
import com.example.h2.api.modelo.Language;
import com.example.h2.api.repositorio.RepositorioLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicioLanguageImpl implements  ServicioLanguage{
    private  final RepositorioLanguage repositorioLanguage;
    @Override
    public Language guardarLanguage(Language language) {
        return repositorioLanguage.save(language);
    }
    @Override
    public Optional<Language> obtenerLanguage(Long id) {
        return Optional.ofNullable(repositorioLanguage.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }
    @Override
    public Language languageAModificar(Long id, Language languageModificar) {
        Language LanguageBuscado=repositorioLanguage.findById(id).get();
        LanguageBuscado.setName_L(languageModificar.getName_L());
        return  repositorioLanguage.save(LanguageBuscado);
    }
    @Override
    public boolean eliminarLanguage(Long id) {
        try {
            repositorioLanguage.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
