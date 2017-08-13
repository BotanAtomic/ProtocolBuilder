package package com.ankamagames.dofus.network.messages.game.context.roleplay;

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
import java.lang.Exception;
import java.lang.Exception;

public class MapComplementaryInformationsDataInHavenBagMessage extends MapComplementaryInformationsDataMessage implements INetworkMessage {

    private int protocolId = 6622;
    private boolean _isInitialized = false;
    private CharacterMinimalInformations ownerInformations = ;
    private int theme = 0;
    private int roomId = 0;
    private int maxRoomId = 0;
    private FuncTree _ownerInformationstree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6622;
    }

    public MapComplementaryInformationsDataInHavenBagMessage initMapComplementaryInformationsDataInHavenBagMessage(int param1,int  param2,Vector.<HouseInformations>  param3,Vector.<GameRolePlayActorInformations>  param4,Vector.<InteractiveElement>  param5,Vector.<StatedElement>  param6,Vector.<MapObstacle>  param7,Vector.<FightCommonInformations>  param8,boolean  param9,FightStartingPositions  param10,CharacterMinimalInformations  param11,int  param12,int  param13,int  param14) {
         super.initMapComplementaryInformationsDataMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.ownerInformations = param11;
         this.theme = param12;
         this.roomId = param13;
         this.maxRoomId = param14;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.ownerInformations = new CharacterMinimalInformations();
         this.roomId = 0;
         this.maxRoomId = 0;
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
         this.serializeAs_MapComplementaryInformationsDataInHavenBagMessage(param1);
    }

    public void serializeAs_MapComplementaryInformationsDataInHavenBagMessage(ICustomDataOutput param1) {
         super.serializeAs_MapComplementaryInformationsDataMessage(param1);
         this.ownerInformations.serializeAs_CharacterMinimalInformations(param1);
         param1.writeByte(this.theme);
         if(this.roomId < 0)
            throw new Exception("Forbidden value (" + this.roomId + ") on element roomId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapComplementaryInformationsDataInHavenBagMessage(param1);
    }

    public void deserializeAs_MapComplementaryInformationsDataInHavenBagMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.ownerInformations = new CharacterMinimalInformations();
         this.ownerInformations.deserialize(param1);
         this._themeFunc(param1);
         this._roomIdFunc(param1);
         this._maxRoomIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapComplementaryInformationsDataInHavenBagMessage(param1);
    }

    public void deserializeAsyncAs_MapComplementaryInformationsDataInHavenBagMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._ownerInformationstree = param1.addChild(this._ownerInformationstreeFunc);
         param1.addChild(this._themeFunc);
         param1.addChild(this._roomIdFunc);
         param1.addChild(this._maxRoomIdFunc);
    }

    private void _ownerInformationstreeFunc(ICustomDataInput param1) {
         this.ownerInformations = new CharacterMinimalInformations();
         this.ownerInformations.deserializeAsync(this._ownerInformationstree);
    }

    private void _themeFunc(ICustomDataInput param1) {
         this.theme = param1.readByte();
    }

    private void _roomIdFunc(ICustomDataInput param1) {
         this.roomId = param1.readByte();
         if(this.roomId < 0)
            throw new Exception("Forbidden value (" + this.roomId + ") on element of MapComplementaryInformationsDataInHavenBagMessage.roomId.");
    }

    private void _maxRoomIdFunc(ICustomDataInput param1) {
         this.maxRoomId = param1.readByte();
         if(this.maxRoomId < 0)
            throw new Exception("Forbidden value (" + this.maxRoomId + ") on element of MapComplementaryInformationsDataInHavenBagMessage.maxRoomId.");
    }

}