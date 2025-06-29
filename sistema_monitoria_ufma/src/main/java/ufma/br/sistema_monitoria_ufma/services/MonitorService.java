package ufma.br.sistema_monitoria_ufma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import ufma.br.sistema_monitoria_ufma.model.Dto.MonitorDto;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MonitorService {

    @Autowired
    MonitorDto mdto;

}
