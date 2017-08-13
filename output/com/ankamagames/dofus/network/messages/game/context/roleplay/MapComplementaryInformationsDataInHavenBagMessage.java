package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.dofus.network.types.game.house.HouseInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.dofus.network.types.game.interactive.MapObstacle;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MapComplementaryInformationsDataInHavenBagMessage extends MapComplementaryInformationsDataMessage implements INetworkMessage {

    private int protocolId = 6622;
    private boolean _isInitialized = false;
    private CharacterMinimalInformations ownerInformations;
    private int theme = 0;
    private int roomId = 0;
    private int maxRoomId = 0;
    private FuncTree _ownerInformationstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
         }
         param1.writeInt(this.mapId);
         param1.writeShort(this.houses.length);
         int _loc2_ = 0;
         while(_loc2_ < this.houses.length)
         {
            param1.writeShort((this.houses[_loc2_] as HouseInformations).getTypeId());
            (this.houses[_loc2_] as HouseInformations).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.actors.length);
         int _loc3_ = 0;
         while(_loc3_ < this.actors.length)
         {
            param1.writeShort((this.actors[_loc3_] as GameRolePlayActorInformations).getTypeId());
            (this.actors[_loc3_] as GameRolePlayActorInformations).serialize(param1);
            _loc3_++;
         }
         param1.writeShort(this.interactiveElements.length);
         int _loc4_ = 0;
         while(_loc4_ < this.interactiveElements.length)
         {
            param1.writeShort((this.interactiveElements[_loc4_] as InteractiveElement).getTypeId());
            (this.interactiveElements[_loc4_] as InteractiveElement).serialize(param1);
            _loc4_++;
         }
         param1.writeShort(this.statedElements.length);
         int _loc5_ = 0;
         while(_loc5_ < this.statedElements.length)
         {
            (this.statedElements[_loc5_] as StatedElement).serializeAs_StatedElement(param1);
            _loc5_++;
         }
         param1.writeShort(this.obstacles.length);
         int _loc6_ = 0;
         while(_loc6_ < this.obstacles.length)
         {
            (this.obstacles[_loc6_] as MapObstacle).serializeAs_MapObstacle(param1);
            _loc6_++;
         }
         param1.writeShort(this.fights.length);
         int _loc7_ = 0;
         while(_loc7_ < this.fights.length)
         {
            (this.fights[_loc7_] as FightCommonInformations).serializeAs_FightCommonInformations(param1);
            _loc7_++;
         }
         param1.writeBoolean(this.hasAggressiveMonsters);
         this.fightStartPositions.serializeAs_FightStartingPositions(param1);
         this.ownerInformations.serializeAs_CharacterMinimalInformations(param1);
         param1.writeByte(this.theme);
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element roomId.");
         }
         param1.writeByte(this.roomId);
         if(this.maxRoomId < 0)
         {
            throw new Exception("Forbidden value (" + this.maxRoomId + ") on element maxRoomId.");
         }
         param1.writeByte(this.maxRoomId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapComplementaryInformationsDataMessage(param1);
         this.ownerInformations = new CharacterMinimalInformations();
         this.ownerInformations.deserialize(param1);
         this.theme = param1.readByte();
         this.roomId = param1.readByte();
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element of MapComplementaryInformationsDataInHavenBagMessage.roomId.");
         }
         this.maxRoomId = param1.readByte();
         if(this.maxRoomId < 0)
         {
            throw new Exception("Forbidden value (" + this.maxRoomId + ") on element of MapComplementaryInformationsDataInHavenBagMessage.maxRoomId.");
         }
    }

}