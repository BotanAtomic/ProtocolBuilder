package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MapFightStartPositionsUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6716;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private FightStartingPositions fightStartPositions = ;
    private FuncTree _fightStartPositionstree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6716;
    }

    public MapFightStartPositionsUpdateMessage initMapFightStartPositionsUpdateMessage(int param1,FightStartingPositions  param2) {
         this.mapId = param1;
         this.fightStartPositions = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mapId = 0;
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
         this.serializeAs_MapFightStartPositionsUpdateMessage(param1);
    }

    public void serializeAs_MapFightStartPositionsUpdateMessage(ICustomDataOutput param1) {
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapFightStartPositionsUpdateMessage(param1);
    }

    public void deserializeAs_MapFightStartPositionsUpdateMessage(ICustomDataInput param1) {
         this._mapIdFunc(param1);
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapFightStartPositionsUpdateMessage(param1);
    }

    public void deserializeAsyncAs_MapFightStartPositionsUpdateMessage(FuncTree param1) {
         param1.addChild(this._mapIdFunc);
         this._fightStartPositionstree = param1.addChild(this._fightStartPositionstreeFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element of MapFightStartPositionsUpdateMessage.mapId.");
    }

    private void _fightStartPositionstreeFunc(ICustomDataInput param1) {
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserializeAsync(this._fightStartPositionstree);
    }

}