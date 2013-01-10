package com.vmware.demo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vmware.demo.db.dao.OrganizationHandler;
import com.vmware.demo.db.entity.IdentityProvider;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EditController {
	
	private static final Logger logger = LoggerFactory.getLogger(EditController.class);

	@Autowired
	private OrganizationHandler organizationHandler;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String load(Locale locale, Model model, Integer id) {
		logger.info("Edit load "+id);
		
		IdentityProvider idp;
		if (0==id) {
			idp = new IdentityProvider();
			logger.debug("created idp ");
		} else {
			idp = organizationHandler.load(id);
			logger.debug("loaded idp: "+idp.getId());
		}
		model.addAttribute("identityProvider", idp);
		
		return "edit";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Locale locale, Model model, Integer id, String name, String horizonUrl, String metaData) {
		logger.info("Edit save "+ name);
		IdentityProvider idp;
		if (0==id ) {
			idp = new IdentityProvider();
		} else {
			idp = organizationHandler.load(id);
		}

		idp.setHorizonUrl(horizonUrl);
		idp.setMetaData(metaData);

		organizationHandler.save(idp);
		
		model.addAttribute("identityProviders", organizationHandler.getAllIdentityProviders());
		model.addAttribute("spMetaDataUsername", ListController.generateMetaData(request, "urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified"));
		model.addAttribute("spMetaDataEmail", ListController.generateMetaData(request, "urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress"));
		return "list";
	}
}
