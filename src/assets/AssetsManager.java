package assets;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssetsManager {

    public void addAsset(Assets asset) {
        String sql = "INSERT INTO Assets (asset_id, status, location, active, year, model, "
                + "serial_no, manufacturer, warranty_exp, warehouse_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asset.getAssetID());
            pstmt.setString(2, asset.getStatus());
            pstmt.setString(3, asset.getLocation());
            pstmt.setBoolean(4, asset.isActive());
            pstmt.setInt(5, asset.getYear());
            pstmt.setString(6, asset.getModel());
            pstmt.setString(7, asset.getSerialNo());
            pstmt.setString(8, asset.getManufacturer());
            pstmt.setDate(9, new java.sql.Date(asset.getWarrantyExp().getTime()));
            pstmt.setString(10, asset.getWarehouseID());

            pstmt.executeUpdate();
            System.out.println("Asset added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding asset: " + e.getMessage());
        }
    }

    public void updateAsset(String assetID, Assets asset) {
        String sql = "UPDATE Assets SET status = ?, location = ?, active = ?, year = ?, "
                + "model = ?, serial_no = ?, manufacturer = ?, warranty_exp = ?, warehouse_id = ? "
                + "WHERE asset_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asset.getStatus());
            pstmt.setString(2, asset.getLocation());
            pstmt.setBoolean(3, asset.isActive());
            pstmt.setInt(4, asset.getYear());
            pstmt.setString(5, asset.getModel());
            pstmt.setString(6, asset.getSerialNo());
            pstmt.setString(7, asset.getManufacturer());
            pstmt.setDate(8, new java.sql.Date(asset.getWarrantyExp().getTime()));
            pstmt.setString(9, asset.getWarehouseID());
            pstmt.setString(10, assetID);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Asset updated successfully!");
            } else {
                System.out.println("Asset not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating asset: " + e.getMessage());
        }
    }

    public void deleteAsset(String assetID) {
        String sql = "DELETE FROM Assets WHERE asset_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assetID);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("Asset deleted successfully!");
            } else {
                System.out.println("Asset not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting asset: " + e.getMessage());
        }
    }

    public Assets getAsset(String assetID) {
        String sql = "SELECT * FROM Assets WHERE asset_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assetID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Assets(
                    rs.getString("asset_id"),
                    rs.getString("status"),
                    rs.getString("location"),
                    rs.getBoolean("active"),
                    rs.getInt("year"),
                    rs.getString("model"),
                    rs.getString("serial_no"),
                    rs.getString("manufacturer"),
                    rs.getDate("warranty_exp"),
                    rs.getString("warehouse_id")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving asset: " + e.getMessage());
        }
        return null;
    }

    public List<Assets> getAllAssets() {
        List<Assets> assets = new ArrayList<>();
        String sql = "SELECT * FROM Assets";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                assets.add(new Assets(
                    rs.getString("asset_id"),
                    rs.getString("status"),
                    rs.getString("location"),
                    rs.getBoolean("active"),
                    rs.getInt("year"),
                    rs.getString("model"),
                    rs.getString("serial_no"),
                    rs.getString("manufacturer"),
                    rs.getDate("warranty_exp"),
                    rs.getString("warehouse_id")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving assets: " + e.getMessage());
        }
        return assets;
    }
}