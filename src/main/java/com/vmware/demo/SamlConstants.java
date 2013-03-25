/*****************************************************************
 * Copyright (c) 2013 VMware, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vmware.demo;
public final class SamlConstants {

    private SamlConstants() {} // Hiding utility-class constructor.

    // Endpoints for Saml
    public static final String METADATA_IDP_ENDPOINT = "/metadata/idp.xml";
    public static final String LOGOUT_ENDPOINT = "/logout/";
    public static final String SSO_ENDPOINT = "/authenticate/";

    // Strings for PEM formatting
    public static final CharSequence BEGIN_CERT = "BEGIN CERTIFICATE";
    public static final CharSequence BEGIN_PRIVATE = "BEGIN RSA PRIVATE KEY";
    public static final String BEGIN_PRIVATE_FULL = "-----BEGIN RSA PRIVATE KEY-----";
    public static final String END_PRIVATE_FULL = "-----END RSA PRIVATE KEY-----";
    public static final String BEGIN_CERT_FULL = "-----BEGIN CERTIFICATE-----";
    public static final String END_CERT_FULL = "-----END CERTIFICATE-----";
}
