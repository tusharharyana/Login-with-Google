
function Login() {

  const handleGoogleLogin = () => {
    window.location.href = "http://localhost:8080/auth/google/login";
  };

  return (
    <div style={{ textAlign: "center", marginTop: "100px" }}>
      <h2>OAuth Practice</h2>

      <button onClick={handleGoogleLogin}>
        Login with Google
      </button>
    </div>
  );
}

export default Login;