package package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockInformationsForSell extends Object implements INetworkType {

    private int protocolId = 222;
    private String guildOwner = "";
    private int worldX = 0;
    private int worldY = 0;
    private int subAreaId = 0;
    private int nbMount = 0;
    private int nbObject = 0;
    private Number price = 0;


    public int getTypeId() {
         return 222;
    }

    public PaddockInformationsForSell initPaddockInformationsForSell(String param1,int  param2,int  param3,int  param4,int  param5,int  param6,Number  param7) {
         this.guildOwner = param1;
         this.worldX = param2;
         this.worldY = param3;
         this.subAreaId = param4;
         this.nbMount = param5;
         this.nbObject = param6;
         this.price = param7;
         return this;
    }

    public void reset() {
         this.guildOwner = "";
         this.worldX = 0;
         this.worldY = 0;
         this.subAreaId = 0;
         this.nbMount = 0;
         this.nbObject = 0;
         this.price = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockInformationsForSell(param1);
    }

    public void serializeAs_PaddockInformationsForSell(ICustomDataOutput param1) {
         param1.writeUTF(this.guildOwner);
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockInformationsForSell(param1);
    }

    public void deserializeAs_PaddockInformationsForSell(ICustomDataInput param1) {
         this._guildOwnerFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._subAreaIdFunc(param1);
         this._nbMountFunc(param1);
         this._nbObjectFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockInformationsForSell(param1);
    }

    public void deserializeAsyncAs_PaddockInformationsForSell(FuncTree param1) {
         param1.addChild(this._guildOwnerFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._nbMountFunc);
         param1.addChild(this._nbObjectFunc);
         param1.addChild(this._priceFunc);
    }

    private void _guildOwnerFunc(ICustomDataInput param1) {
         this.guildOwner = param1.readUTF();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PaddockInformationsForSell.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PaddockInformationsForSell.worldY.");
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PaddockInformationsForSell.subAreaId.");
    }

    private void _nbMountFunc(ICustomDataInput param1) {
         this.nbMount = param1.readByte();
    }

    private void _nbObjectFunc(ICustomDataInput param1) {
         this.nbObject = param1.readByte();
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }

}