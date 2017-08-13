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
import java.lang.Exception;

public class GameFightOptionStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5927;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private int teamId = 2;
    private int option = 3;
    private boolean state = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5927;
    }

    public GameFightOptionStateUpdateMessage initGameFightOptionStateUpdateMessage(int param1,int  param2,int  param3,boolean  param4) {
         this.fightId = param1;
         this.teamId = param2;
         this.option = param3;
         this.state = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.teamId = 2;
         this.option = 3;
         this.state = false;
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
         this.serializeAs_GameFightOptionStateUpdateMessage(param1);
    }

    public void serializeAs_GameFightOptionStateUpdateMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightOptionStateUpdateMessage(param1);
    }

    public void deserializeAs_GameFightOptionStateUpdateMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this._teamIdFunc(param1);
         this._optionFunc(param1);
         this._stateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightOptionStateUpdateMessage(param1);
    }

    public void deserializeAsyncAs_GameFightOptionStateUpdateMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._teamIdFunc);
         param1.addChild(this._optionFunc);
         param1.addChild(this._stateFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readShort();
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameFightOptionStateUpdateMessage.fightId.");
    }

    private void _teamIdFunc(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightOptionStateUpdateMessage.teamId.");
    }

    private void _optionFunc(ICustomDataInput param1) {
         this.option = param1.readByte();
         if(this.option < 0)
            throw new Exception("Forbidden value (" + this.option + ") on element of GameFightOptionStateUpdateMessage.option.");
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readBoolean();
    }

}