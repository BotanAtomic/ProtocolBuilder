package com.ankamagames.dofus.network.types.game.guild;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildEmblem extends Object implements INetworkType {

    private int protocolId = 87;
    private int symbolShape = 0;
    private int symbolColor = 0;
    private int backgroundShape = 0;
    private int backgroundColor = 0;


    public int getTypeId() {
         return 87;
    }

    public GuildEmblem initGuildEmblem(int param1,int  param2,int  param3,int  param4) {
         this.symbolShape = param1;
         this.symbolColor = param2;
         this.backgroundShape = param3;
         this.backgroundColor = param4;
         return this;
    }

    public void reset() {
         this.symbolShape = 0;
         this.symbolColor = 0;
         this.backgroundShape = 0;
         this.backgroundColor = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildEmblem(param1);
    }

    public void serializeAs_GuildEmblem(ICustomDataOutput param1) {
         if(this.symbolShape < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolShape + ") on element symbolShape.");
         }
         param1.writeVarShort(this.symbolShape);
         param1.writeInt(this.symbolColor);
         if(this.backgroundShape < 0)
         {
            throw new Exception("Forbidden value (" + this.backgroundShape + ") on element backgroundShape.");
         }
         param1.writeByte(this.backgroundShape);
         param1.writeInt(this.backgroundColor);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildEmblem(param1);
    }

    public void deserializeAs_GuildEmblem(ICustomDataInput param1) {
         this._symbolShapeFunc(param1);
         this._symbolColorFunc(param1);
         this._backgroundShapeFunc(param1);
         this._backgroundColorFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildEmblem(param1);
    }

    public void deserializeAsyncAs_GuildEmblem(FuncTree param1) {
         param1.addChild(this._symbolShapeFunc);
         param1.addChild(this._symbolColorFunc);
         param1.addChild(this._backgroundShapeFunc);
         param1.addChild(this._backgroundColorFunc);
    }

    private void _symbolShapeFunc(ICustomDataInput param1) {
         this.symbolShape = param1.readVarUhShort();
         if(this.symbolShape < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolShape + ") on element of GuildEmblem.symbolShape.");
         }
    }

    private void _symbolColorFunc(ICustomDataInput param1) {
         this.symbolColor = param1.readInt();
    }

    private void _backgroundShapeFunc(ICustomDataInput param1) {
         this.backgroundShape = param1.readByte();
         if(this.backgroundShape < 0)
         {
            throw new Exception("Forbidden value (" + this.backgroundShape + ") on element of GuildEmblem.backgroundShape.");
         }
    }

    private void _backgroundColorFunc(ICustomDataInput param1) {
         this.backgroundColor = param1.readInt();
    }

}