import { useEffect } from "react";

function Home() {

  useEffect(() => {
    const params = new URLSearchParams(window.location.search);
    const token = params.get("token");

    console.log("JWT:", token);

    localStorage.setItem("token", token);
  }, []);

  return <h2>Welcome! Logged in successfully 🎉</h2>;
}

export default Home;