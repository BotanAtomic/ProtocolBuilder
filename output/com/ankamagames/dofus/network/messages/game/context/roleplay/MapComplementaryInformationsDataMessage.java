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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MapComplementaryInformationsDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 226;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int mapId = 0;
    private Vector<HouseInformations> houses;
    private Vector<GameRolePlayActorInformations> actors;
    private Vector<InteractiveElement> interactiveElements;
    private Vector<StatedElement> statedElements;
    private Vector<MapObstacle> obstacles;
    private Vector<FightCommonInformations> fights;
    private boolean hasAggressiveMonsters = false;
    private FightStartingPositions fightStartPositions;
    private FuncTree _housestree;
    private FuncTree _actorstree;
    private FuncTree _interactiveElementstree;
    private FuncTree _statedElementstree;
    private FuncTree _obstaclestree;
    private FuncTree _fightstree;
    private FuncTree _fightStartPositionstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 226;
    }

    public MapComplementaryInformationsDataMessage initMapComplementaryInformationsDataMessage(int param1,int  param2,Vector<HouseInformations>  param3,Vector<GameRolePlayActorInformations>  param4,Vector<InteractiveElement>  param5,Vector<StatedElement>  param6,Vector<MapObstacle>  param7,Vector<FightCommonInformations>  param8,boolean  param9,FightStartingPositions  param10) {
         this.subAreaId = param1;
         this.mapId = param2;
         this.houses = param3;
         this.actors = param4;
         this.interactiveElements = param5;
         this.statedElements = param6;
         this.obstacles = param7;
         this.fights = param8;
         this.hasAggressiveMonsters = param9;
         this.fightStartPositions = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.mapId = 0;
         this.houses = new Vector.<HouseInformations>();
         this.actors = new Vector.<GameRolePlayActorInformations>();
         this.interactiveElements = new Vector.<InteractiveElement>();
         this.statedElements = new Vector.<StatedElement>();
         this.obstacles = new Vector.<MapObstacle>();
         this.fights = new Vector.<FightCommonInformations>();
         this.hasAggressiveMonsters = false;
         this.fightStartPositions = new FightStartingPositions();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MapComplementaryInformationsDataMessage(param1);
    }

    public void serializeAs_MapComplementaryInformationsDataMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_MapComplementaryInformationsDataMessage(param1);
    }

    public void deserializeAs_MapComplementaryInformationsDataMessage(ICustomDataInput param1) {
         int _loc14_ = 0;
         HouseInformations _loc15_ = null;
         int _loc16_ = 0;
         GameRolePlayActorInformations _loc17_ = null;
         int _loc18_ = 0;
         InteractiveElement _loc19_ = null;
         StatedElement _loc20_ = null;
         MapObstacle _loc21_ = null;
         FightCommonInformations _loc22_ = null;
         this._subAreaIdFunc(param1);
         this._mapIdFunc(param1);
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
         this._hasAggressiveMonstersFunc(param1);
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapComplementaryInformationsDataMessage(param1);
    }

    public void deserializeAsyncAs_MapComplementaryInformationsDataMessage(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._mapIdFunc);
         this._housestree = param1.addChild(this._housestreeFunc);
         this._actorstree = param1.addChild(this._actorstreeFunc);
         this._interactiveElementstree = param1.addChild(this._interactiveElementstreeFunc);
         this._statedElementstree = param1.addChild(this._statedElementstreeFunc);
         this._obstaclestree = param1.addChild(this._obstaclestreeFunc);
         this._fightstree = param1.addChild(this._fightstreeFunc);
         param1.addChild(this._hasAggressiveMonstersFunc);
         this._fightStartPositionstree = param1.addChild(this._fightStartPositionstreeFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of MapComplementaryInformationsDataMessage.subAreaId.");
         }
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of MapComplementaryInformationsDataMessage.mapId.");
         }
    }

    private void _housestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._housestree.addChild(this._housesFunc);
            _loc3_++;
         }
    }

    private void _housesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         HouseInformations _loc3_ = ProtocolTypeManager.getInstance(HouseInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.houses.push(_loc3_);
    }

    private void _actorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._actorstree.addChild(this._actorsFunc);
            _loc3_++;
         }
    }

    private void _actorsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameRolePlayActorInformations _loc3_ = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.actors.push(_loc3_);
    }

    private void _interactiveElementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._interactiveElementstree.addChild(this._interactiveElementsFunc);
            _loc3_++;
         }
    }

    private void _interactiveElementsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         InteractiveElement _loc3_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc2_);
         _loc3_.deserialize(param1);
         this.interactiveElements.push(_loc3_);
    }

    private void _statedElementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._statedElementstree.addChild(this._statedElementsFunc);
            _loc3_++;
         }
    }

    private void _statedElementsFunc(ICustomDataInput param1) {
         StatedElement _loc2_ = new StatedElement();
         _loc2_.deserialize(param1);
         this.statedElements.push(_loc2_);
    }

    private void _obstaclestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._obstaclestree.addChild(this._obstaclesFunc);
            _loc3_++;
         }
    }

    private void _obstaclesFunc(ICustomDataInput param1) {
         MapObstacle _loc2_ = new MapObstacle();
         _loc2_.deserialize(param1);
         this.obstacles.push(_loc2_);
    }

    private void _fightstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._fightstree.addChild(this._fightsFunc);
            _loc3_++;
         }
    }

    private void _fightsFunc(ICustomDataInput param1) {
         FightCommonInformations _loc2_ = new FightCommonInformations();
         _loc2_.deserialize(param1);
         this.fights.push(_loc2_);
    }

    private void _hasAggressiveMonstersFunc(ICustomDataInput param1) {
         this.hasAggressiveMonsters = param1.readBoolean();
    }

    private void _fightStartPositionstreeFunc(ICustomDataInput param1) {
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserializeAsync(this._fightStartPositionstree);
    }

}