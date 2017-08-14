package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.dofus.network.types.game.interactive.MapObstacle;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapComplementaryInformationsWithCoordsMessage
    extends MapComplementaryInformationsDataMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int worldX = 0;
  public int worldY = 0;
  public static final int protocolId = 6268;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.subAreaId < 0) {
      throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    if (this.mapId < 0) {
      throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }
    param1.writeInt(this.mapId);
    param1.writeShort(this.houses.length);
    int _loc2_ = 0;
    while (_loc2_ < this.houses.length) {
      param1.writeShort(((HouseInformations) (this.houses[_loc2_])).getTypeId());
      ((HouseInformations) this.houses[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.actors.length);
    int _loc3_ = 0;
    while (_loc3_ < this.actors.length) {
      param1.writeShort(((GameRolePlayActorInformations) (this.actors[_loc3_])).getTypeId());
      ((GameRolePlayActorInformations) this.actors[_loc3_]).serialize(param1);
      _loc3_++;
    }
    param1.writeShort(this.interactiveElements.length);
    int _loc4_ = 0;
    while (_loc4_ < this.interactiveElements.length) {
      param1.writeShort(((InteractiveElement) (this.interactiveElements[_loc4_])).getTypeId());
      ((InteractiveElement) this.interactiveElements[_loc4_]).serialize(param1);
      _loc4_++;
    }
    param1.writeShort(this.statedElements.length);
    int _loc5_ = 0;
    while (_loc5_ < this.statedElements.length) {
      ((StatedElement) this.statedElements[_loc5_]).serializeAs_(param1);
      _loc5_++;
    }
    param1.writeShort(this.obstacles.length);
    int _loc6_ = 0;
    while (_loc6_ < this.obstacles.length) {
      ((MapObstacle) this.obstacles[_loc6_]).serializeAs_(param1);
      _loc6_++;
    }
    param1.writeShort(this.fights.length);
    int _loc7_ = 0;
    while (_loc7_ < this.fights.length) {
      ((FightCommonInformations) this.fights[_loc7_]).serializeAs_(param1);
      _loc7_++;
    }
    param1.writeBoolean(this.hasAggressiveMonsters);
    this.fightStartPositions.serializeAs_FightStartingPositions(param1);

    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.worldX = param1.readShort();
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldX
              + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    this.worldY = param1.readShort();
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldY
              + ") on element of PrismGeolocalizedInformation.worldY.");
    }
  }
}
