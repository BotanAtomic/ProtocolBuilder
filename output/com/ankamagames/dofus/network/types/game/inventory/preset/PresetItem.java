package package com.ankamagames.dofus.network.types.game.inventory.preset;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PresetItem extends Object implements INetworkType {

    private int protocolId = 354;
    private int position = 63;
    private int objGid = 0;
    private int objUid = 0;


    public int getTypeId() {
         return 354;
    }

    public PresetItem initPresetItem(int param1,int  param2,int  param3) {
         this.position = param1;
         this.objGid = param2;
         this.objUid = param3;
         return this;
    }

    public void reset() {
         this.position = 63;
         this.objGid = 0;
         this.objUid = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PresetItem(param1);
    }

    public void serializeAs_PresetItem(ICustomDataOutput param1) {
         param1.writeByte(this.position);
         if(this.objGid < 0)
            throw new Exception("Forbidden value (" + this.objGid + ") on element objGid.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PresetItem(param1);
    }

    public void deserializeAs_PresetItem(ICustomDataInput param1) {
         this._positionFunc(param1);
         this._objGidFunc(param1);
         this._objUidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PresetItem(param1);
    }

    public void deserializeAsyncAs_PresetItem(FuncTree param1) {
         param1.addChild(this._positionFunc);
         param1.addChild(this._objGidFunc);
         param1.addChild(this._objUidFunc);
    }

    private void _positionFunc(ICustomDataInput param1) {
         this.position = param1.readUnsignedByte();
         if(this.position < 0 || this.position > 255)
            throw new Exception("Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }

    private void _objGidFunc(ICustomDataInput param1) {
         this.objGid = param1.readVarUhShort();
         if(this.objGid < 0)
            throw new Exception("Forbidden value (" + this.objGid + ") on element of PresetItem.objGid.");
    }

    private void _objUidFunc(ICustomDataInput param1) {
         this.objUid = param1.readVarUhInt();
         if(this.objUid < 0)
            throw new Exception("Forbidden value (" + this.objUid + ") on element of PresetItem.objUid.");
    }

}