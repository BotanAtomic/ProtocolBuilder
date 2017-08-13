package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
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
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class MapComplementaryInformationsDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 226;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int mapId = 0;
    private HouseInformations[] houses;
    private GameRolePlayActorInformations[] actors;
    private InteractiveElement[] interactiveElements;
    private StatedElement[] statedElements;
    private MapObstacle[] obstacles;
    private FightCommonInformations[] fights;
    private boolean hasAggressiveMonsters = false;
    private FightStartingPositions fightStartPositions;
    private FuncTree _housestree;
    private FuncTree _actorstree;
    private FuncTree _interactiveElementstree;
    private FuncTree _statedElementstree;
    private FuncTree _obstaclestree;
    private FuncTree _fightstree;
    private FuncTree _fightStartPositionstree;


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
    }

}