export default function MovieCard ({ title, genre }) {
  return (
    <div style={{ border: '1px solid black', margin: '6px', padding: '5px' }}>
      <h3>{title}</h3>
      <p>{genre}</p>
    </div>
  )
}
