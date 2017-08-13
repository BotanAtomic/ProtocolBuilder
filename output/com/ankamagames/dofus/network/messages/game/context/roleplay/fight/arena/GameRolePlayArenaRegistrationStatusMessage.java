package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayArenaRegistrationStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6284;
    private boolean _isInitialized = false;
    private boolean registered = false;
    private int step = 0;
    private int battleMode = 3;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6284;
    }

    public GameRolePlayArenaRegistrationStatusMessage initGameRolePlayArenaRegistrationStatusMessage(boolean param1,int  param2,int  param3) {
         this.registered = param1;
         this.step = param2;
         this.battleMode = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.registered = false;
         this.step = 0;
         this.battleMode = 3;
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
         this.serializeAs_GameRolePlayArenaRegistrationStatusMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaRegistrationStatusMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.registered);
         param1.writeByte(this.step);
         param1.writeInt(this.battleMode);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaRegistrationStatusMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaRegistrationStatusMessage(ICustomDataInput param1) {
         this._registeredFunc(param1);
         this._stepFunc(param1);
         this._battleModeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaRegistrationStatusMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaRegistrationStatusMessage(FuncTree param1) {
         param1.addChild(this._registeredFunc);
         param1.addChild(this._stepFunc);
         param1.addChild(this._battleModeFunc);
    }

    private void _registeredFunc(ICustomDataInput param1) {
         this.registered = param1.readBoolean();
    }

    private void _stepFunc(ICustomDataInput param1) {
         this.step = param1.readByte();
         if(this.step < 0)
         {
            throw new Exception("Forbidden value (" + this.step + ") on element of GameRolePlayArenaRegistrationStatusMessage.step.");
         }
    }

    private void _battleModeFunc(ICustomDataInput param1) {
         this.battleMode = param1.readInt();
         if(this.battleMode < 0)
         {
            throw new Exception("Forbidden value (" + this.battleMode + ") on element of GameRolePlayArenaRegistrationStatusMessage.battleMode.");
         }
    }

}