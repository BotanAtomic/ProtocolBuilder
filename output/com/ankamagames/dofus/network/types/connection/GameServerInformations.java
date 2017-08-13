package package com.ankamagames.dofus.network.types.connection;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameServerInformations extends Object implements INetworkType {

    private int protocolId = 25;
    private int id = 0;
    private int type = -1;
    private int status = 1;
    private int completion = 0;
    private boolean isSelectable = false;
    private int charactersCount = 0;
    private int charactersSlots = 0;
    private Number date = 0;


    public int getTypeId() {
         return 25;
    }

    public GameServerInformations initGameServerInformations(int param1,int  param2,int  param3,int  param4,boolean  param5,int  param6,int  param7,Number  param8) {
         this.id = param1;
         this.type = param2;
         this.status = param3;
         this.completion = param4;
         this.isSelectable = param5;
         this.charactersCount = param6;
         this.charactersSlots = param7;
         this.date = param8;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.type = -1;
         this.status = 1;
         this.completion = 0;
         this.isSelectable = false;
         this.charactersCount = 0;
         this.charactersSlots = 0;
         this.date = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameServerInformations(param1);
    }

    public void serializeAs_GameServerInformations(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameServerInformations(param1);
    }

    public void deserializeAs_GameServerInformations(ICustomDataInput param1) {
         this._idFunc(param1);
         this._typeFunc(param1);
         this._statusFunc(param1);
         this._completionFunc(param1);
         this._isSelectableFunc(param1);
         this._charactersCountFunc(param1);
         this._charactersSlotsFunc(param1);
         this._dateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameServerInformations(param1);
    }

    public void deserializeAsyncAs_GameServerInformations(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._typeFunc);
         param1.addChild(this._statusFunc);
         param1.addChild(this._completionFunc);
         param1.addChild(this._isSelectableFunc);
         param1.addChild(this._charactersCountFunc);
         param1.addChild(this._charactersSlotsFunc);
         param1.addChild(this._dateFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of GameServerInformations.id.");
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
    }

    private void _statusFunc(ICustomDataInput param1) {
         this.status = param1.readByte();
         if(this.status < 0)
            throw new Exception("Forbidden value (" + this.status + ") on element of GameServerInformations.status.");
    }

    private void _completionFunc(ICustomDataInput param1) {
         this.completion = param1.readByte();
         if(this.completion < 0)
            throw new Exception("Forbidden value (" + this.completion + ") on element of GameServerInformations.completion.");
    }

    private void _isSelectableFunc(ICustomDataInput param1) {
         this.isSelectable = param1.readBoolean();
    }

    private void _charactersCountFunc(ICustomDataInput param1) {
         this.charactersCount = param1.readByte();
         if(this.charactersCount < 0)
            throw new Exception("Forbidden value (" + this.charactersCount + ") on element of GameServerInformations.charactersCount.");
    }

    private void _charactersSlotsFunc(ICustomDataInput param1) {
         this.charactersSlots = param1.readByte();
         if(this.charactersSlots < 0)
            throw new Exception("Forbidden value (" + this.charactersSlots + ") on element of GameServerInformations.charactersSlots.");
    }

    private void _dateFunc(ICustomDataInput param1) {
         this.date = param1.readDouble();
         if(this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.date + ") on element of GameServerInformations.date.");
    }

}