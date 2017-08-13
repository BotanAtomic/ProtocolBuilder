package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightNewWaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6490;
    private boolean _isInitialized = false;
    private int id = 0;
    private int teamId = 2;
    private int nbTurnBeforeNextWave = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6490;
    }

    public GameFightNewWaveMessage initGameFightNewWaveMessage(int param1,int  param2,int  param3) {
         this.id = param1;
         this.teamId = param2;
         this.nbTurnBeforeNextWave = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.teamId = 2;
         this.nbTurnBeforeNextWave = 0;
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
         this.serializeAs_GameFightNewWaveMessage(param1);
    }

    public void serializeAs_GameFightNewWaveMessage(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightNewWaveMessage(param1);
    }

    public void deserializeAs_GameFightNewWaveMessage(ICustomDataInput param1) {
         this._idFunc(param1);
         this._teamIdFunc(param1);
         this._nbTurnBeforeNextWaveFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightNewWaveMessage(param1);
    }

    public void deserializeAsyncAs_GameFightNewWaveMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._teamIdFunc);
         param1.addChild(this._nbTurnBeforeNextWaveFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readByte();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of GameFightNewWaveMessage.id.");
    }

    private void _teamIdFunc(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightNewWaveMessage.teamId.");
    }

    private void _nbTurnBeforeNextWaveFunc(ICustomDataInput param1) {
         this.nbTurnBeforeNextWave = param1.readShort();
    }

}