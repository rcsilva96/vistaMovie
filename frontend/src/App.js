import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from './pages/Listing/index.tsx';
import Form from './pages/Form/index.tsx';
import Navbar from './components/Navbar/index.tsx';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;