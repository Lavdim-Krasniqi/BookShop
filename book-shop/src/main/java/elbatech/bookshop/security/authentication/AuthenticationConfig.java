package elbatech.bookshop.security.authentication;

//@Configuration
//@EnableWebSecurity
//@EnableAutoConfiguration
//@ComponentScan
public class AuthenticationConfig /**extends WebSecurityConfigurerAdapter **/
{

//    @Autowired
//    @Lazy
//    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
//
//    @Autowired
//    @Lazy
//    TokenProvider tokenProvider;
//
//    @Autowired
//    @Lazy
//    UsernamePasswordFilter usernamePasswordFilter;
//
//    @Autowired
//    @Lazy
//    TokenFilter tokenFilter;
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(usernamePasswordAuthenticationProvider)
//                .authenticationProvider(tokenProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
////        http.exceptionHandling()
////                .accessDeniedHandler(accessDeniedHandler)
////                .authenticationEntryPoint(authEntryPoint);
//
//        http.addFilterAt(usernamePasswordFilter, BasicAuthenticationFilter.class)
//                .addFilterAfter(tokenFilter, BasicAuthenticationFilter.class);
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/user/addUser").permitAll()
//                .anyRequest().authenticated();
//
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Autowired
//    AuthenticationEntryPoint authEntryPoint;
//    @Autowired
//    AccessDeniedHandler accessDeniedHandler;

}
