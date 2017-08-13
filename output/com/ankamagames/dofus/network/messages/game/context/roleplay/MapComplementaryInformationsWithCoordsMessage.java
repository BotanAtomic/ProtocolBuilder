package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
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

public class MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsDataMessage implements INetworkMessage {

    private int protocolId = 6268;
    private boolean _isInitialized = false;
    private int worldX = 0;
    private int worldY = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_MapComplementaryInformationsDataMessage(param1);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc14_ = 0;
         HouseInformations _loc15_ = null;
         int _loc16_ = 0;
         GameRolePlayActorInformations _loc17_ = null;
         int _loc18_ = 0;
         InteractiveElement _loc19_ = null;
         StatedElement _loc20_ = null;
         MapObstacle _loc21_ = null;
         FightCommonInformations _loc22_ = null;
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of MapComplementaryInformationsDataMessage.subAreaId.");
         }
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of MapComplementaryInformationsDataMessage.mapId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc14_ = param1.readUnsignedShort();
            _loc15_ = ProtocolTypeManager.getInstance(HouseInformations,_loc14_);
            _loc15_.deserialize(param1);
            this.houses.push(_loc15_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc16_ = param1.readUnsignedShort();
            _loc17_ = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc16_);
            _loc17_.deserialize(param1);
            this.actors.push(_loc17_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc18_ = param1.readUnsignedShort();
            _loc19_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc18_);
            _loc19_.deserialize(param1);
            this.interactiveElements.push(_loc19_);
            _loc7_++;
         }
         int _loc8_ = param1.readUnsignedShort();
         int _loc9_ = 0;
         while(_loc9_ < _loc8_)
         {
            _loc20_ = new StatedElement();
            _loc20_.deserialize(param1);
            this.statedElements.push(_loc20_);
            _loc9_++;
         }
         int _loc10_ = param1.readUnsignedShort();
         int _loc11_ = 0;
         while(_loc11_ < _loc10_)
         {
            _loc21_ = new MapObstacle();
            _loc21_.deserialize(param1);
            this.obstacles.push(_loc21_);
            _loc11_++;
         }
         int _loc12_ = param1.readUnsignedShort();
         int _loc13_ = 0;
         while(_loc13_ < _loc12_)
         {
            _loc22_ = new FightCommonInformations();
            _loc22_.deserialize(param1);
            this.fights.push(_loc22_);
            _loc13_++;
         }
         this.hasAggressiveMonsters = param1.readBoolean();
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of MapComplementaryInformationsWithCoordsMessage.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of MapComplementaryInformationsWithCoordsMessage.worldY.");
         }
    }

}